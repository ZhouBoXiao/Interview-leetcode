package b1;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(new Main().solution(s));
    }
    String solution(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < chars.length ; i++){


            if (chars[i] == '['){
                stack.add(i);
            }else if (chars[i] == ']'){

                int pre = stack.pop();

                int a = s.indexOf("|", pre);
                int times = Integer.parseInt(s.substring(pre+1, a));
                String res = "";
                String S = s.substring(a+1, i);
                for (int j = 0; j < times; j++) {
                    res += S;
                }
                String replaceString = s.substring(pre, i+1);

                return solution(s.replace(replaceString, res));
            }

        }
        return s;
    }


}

class GeoHashBoundingBoxQuery {
    private double[] dLat=new double[41];
    private double[] dLon=new double[41];
    private ArrayList<GeoHash> adjGeoHashs=new ArrayList<>();
    public GeoHashBoundingBoxQuery()
    {
        for(int i=0;i<41;i++)
        {
            dLat[i]=divideLat(i);
            dLon[i]=divideLon(i);
        }

    }

    private double divideLat(int bits)
    {
        return 180/Math.pow(2,bits/2);
    }
    private double divideLon(int bits)
    {
        return 360/Math.pow(2,(bits+1)/2);
    }

    private int numofBitsForOverlappingGeoHash(BoundingBox box)
    {
        int bits=40;//默认值
        double height=box.getLatitudeSize();
        double width=box.getLongitudeSize();
        while((dLat[bits]<height || dLon[bits]<width)&&bits>0){
            bits--;
        }
        System.out.println("fitting Bits:"+bits);
        return bits;
    }

    //由于刚好分割的位数可能不满足5的倍数 ，无法进行base32转换，只能返回其二进制位
    public  ArrayList<String> getOverLapGeoHashBits(BoundingBox box)
    {
        //adjGeoHashs=new ArrayList<>();
        int fittingBits=numofBitsForOverlappingGeoHash(box);//分割的位数
        Point p=box.getCenterPoint();
        GeoHash centerHash=new GeoHash(p.getLon(),p.getLat(),fittingBits);
        if(hashFits(centerHash,box))
        {
            addSearchHash(centerHash);
        }else
        {
            expandSearch(centerHash,box,fittingBits);
        }
        ArrayList<String> strList=getBinryList();
        return strList;
    }

    private boolean hashFits(GeoHash centerHash,BoundingBox b)
    {
        return (centerHash.contains(b.getLowerLeft()) && centerHash.contains(b.getUpperRight()));
    }

    private void addSearchHash(GeoHash g)
    {
        adjGeoHashs.add(g);
    }

    private void expandSearch(GeoHash centerHash,BoundingBox box,int fittingBits)
    {
        addSearchHash(centerHash);
        ArrayList<GeoHash> hashList=centerHash.getAdjacent(fittingBits);//得到周围8个格子
        for(GeoHash adj: hashList)
        {
            BoundingBox adjBox=adj.getGeoHashBox();
            if(adjBox.isIntersect(box))
            {
                addSearchHash(adj);
            }
        }
    }

    private ArrayList<String> getBinryList()
    {
        ArrayList<String> mergBits=new ArrayList<>();
        for(GeoHash g:adjGeoHashs)
        {
            mergBits.add(g.allBits);
        }
        return mergBits;
    }

    private ArrayList<String> getBase32FromHash()
    {
        ArrayList<String> base32Str=new ArrayList<>();
        for(GeoHash g:adjGeoHashs)
        {
            base32Str.add(g.getBase32FromBits());
        }
        return base32Str;
    }

    //矩形查询2：根据选择的范围以及最终分割的GeoHash块大小找出所有覆盖的块编码
//:该方法失败，内存溢出,不单独使用，结合方法三一起使用
    private void addGeoHashFromMinGeohash(BoundingBox box,int numofBits)
    {
        //int numofBits=40;
        double leftBottomLon=box.minLon;
        double leftBottomLat=box.minLat;
        double rightUpperLon=box.maxLon;
        double rightUpperLat=box.maxLat;
        int xStartSize=(int)((leftBottomLon+180)/dLon[numofBits]);
        int xEndSize=(int)((rightUpperLon+180)/dLon[numofBits]);
        int yStartSize=(int)((leftBottomLat+90)/dLat[numofBits]);
        int yEndSize=(int)((rightUpperLat+90)/dLat[numofBits]);
        double minLon;
        double minLat;
        int xdel=xEndSize-xStartSize,ydel=yEndSize-yStartSize;
        for(int x=0;x<=xdel;x++)
        {
            minLon=leftBottomLon+x*dLon[numofBits];
            for(int y=0;y<=ydel;y++)
            {
                minLat=leftBottomLat+y*dLat[numofBits];
                GeoHash geohash=new GeoHash(minLon,minLat,numofBits);
                adjGeoHashs.add(geohash);
            }
        }
	/*
	while(leftBottomLat<rightUpperLat)
	{
		Point endPoint(rightUpperLon,leftBottomLat);
		while(leftBottomLon<rightUpperLon)
		{
			GeoHash geohash(leftBottomLon,leftBottomLat,numofBits);
		    geoHashList.push_back(geohash);
			if(geohash.contains(endPoint))
			{
				break;
			}else
			{
				leftBottomLon+=dLon[numofBits];
				if(leftBottomLon>=rightUpperLon)
				{
					GeoHash geohash(leftBottomLon,leftBottomLat,numofBits);
		            geoHashList.push_back(geohash);
				}
			}
		}
		leftBottomLon=box.minLon;
		leftBottomLat+=dLat[numofBits];
	}
	*/
    }

    //矩形查询3：分割次数刚好凑成5的倍数，采用增加或减少分割次数
    public ArrayList<String> getBoundingGeoHashBase32(BoundingBox box)
    {
        int fittingBits=numofBitsForOverlappingGeoHash(box);//分割的位数
        int residue=fittingBits%5;
        int intVal=fittingBits/5;
        if(residue <=3)
        {
            Point p=box.getCenterPoint();
            GeoHash centerHash=new GeoHash(p.getLon(),p.getLat(),intVal*5);
            if(hashFits(centerHash,box))
            {
                addSearchHash(centerHash);
            }else
            {
                expandSearch(centerHash,box,intVal*5);
            }
        }else
        {
            int divBits=(intVal+1)*5;
            //然后再逐个遍历，找出覆盖的所有栅格
            addGeoHashFromMinGeohash(box,divBits);
        }
        ArrayList<String> base32StrList=getBase32FromHash();
        return base32StrList;
    }
}

class Point {
    private final double longitude;
    private final double latitude;

    public Point(double longitude,double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        if (Math.abs(latitude) > 90 || Math.abs(longitude) > 180) {
            throw new IllegalArgumentException("The supplied coordinates " + this + " are out of range.");
        }
    }

    public double getLon() {
        return longitude;
    }

    public double getLat() {
        return latitude;
    }

}
class GeoHash {
    public String allBits="";
    private int precision;
    private BoundingBox box=new BoundingBox();
    public static char[] base32Table;
    static{
        base32Table=new char[]{'0','1','2','3','4','5','6','7','8','9','b','c','d','e','f','g',
                'h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z'};// Base32编码表
    }
    public GeoHash(double lon, double lat)
    {
        this.precision=45;//默认设置总的二进制串长度为40位
        setMergeBits(lon,lat,precision);
    }
    public GeoHash(double lon,double lat,int prec)
    {
        this.precision=prec;
        setMergeBits(lon,lat,prec);
    }
    public GeoHash(){
        this.precision=45;
    }

    /**
     * 静态内部类单例模式
     * @returnb
     */
    public static GeoHash getInstance(){
        return Inner.instance;
    }



    private static class Inner {
        private static final GeoHash instance = new GeoHash();
    }
    //第二种方法，根据总的精度直接得到混合后的二进制码
    public void setMergeBits(double lon,double lat,int desiredPrecision)
    {
        double[] lonRange = {-180,180};
        double[] latRange = {-90,90};
        boolean isEvenBit=true;
        int significantBits=0;
        while(significantBits<desiredPrecision)
        {
            if(isEvenBit)
            {
                divideRangeEncode(lon,lonRange);
            }else
            {
                divideRangeEncode(lat,latRange);
            }
            isEvenBit=!isEvenBit;
            significantBits++;
        }
        this.box.minLon=lonRange[0];
        this.box.maxLon=lonRange[1];
        this.box.minLat=latRange[0];
        this.box.maxLat=latRange[1];
    }
    private void divideRangeEncode(double data,double range[])
    {
        double mid=(range[0]+range[1])/2;
        if(data>mid)
        {
            allBits +='1';
            range[0]=mid;
        }else
        {
            allBits +='0';
            range[1]=mid;
        }
    }
    //将混合后的二进制码转换为base32字符串
    public String getBase32FromBits()
    {
        String encodeStr="";
        int intVal=precision/5;//转化为多少个base32字符
        if ("".equals(allBits))
            return encodeStr;
        char[] bitsArr=allBits.toCharArray();
        int bin2dec;	/* 将binHash中的每5位二进制码编为1个十进制数 */
        for (int k = 0; k < intVal; k++)
        {
            bin2dec = 0;
            for (int i = k * 5; i < (k + 1) * 5; ++i)
            {
                bin2dec = bin2dec * 2 + (bitsArr[i] == '1' ? 1 : 0);
            }
            encodeStr += base32Table[bin2dec];
        }
        return encodeStr;
    }
    public BoundingBox getGeoHashBox()
    {
        return box;
    }

    public String getBinaryHashs()
    {
        return allBits;
    }

    public boolean contains(Point p)
    {
        return box.isContain(p);
    }

    public ArrayList<GeoHash> getAdjacent(int fittingBits)
    {
        //得到周围8个邻居的GeoHash对象
        ArrayList<GeoHash> neighbors=new ArrayList<>();
        double lonSize=box.maxLon-box.minLon;
        double latSize=box.maxLat-box.minLat;
        double midLon=(box.maxLon+box.minLon)/2;
        double leftLon=midLon-lonSize;
        double rightLon=midLon+lonSize;
        double midLat=(box.maxLat+box.minLat)/2;
        double bottomLat=midLat-latSize;
        double upperLat=midLat+latSize;
        //上
        neighbors.add(new GeoHash(midLon,upperLat,fittingBits));
        //下
        neighbors.add(new GeoHash(midLon,bottomLat,fittingBits));
        //左
        neighbors.add(new GeoHash(leftLon,midLat,fittingBits));
        //右
        neighbors.add(new GeoHash(rightLon,midLat,fittingBits));
        //左上
        neighbors.add(new GeoHash(leftLon,upperLat,fittingBits));
        //右上
        neighbors.add(new GeoHash(rightLon,upperLat,fittingBits));
        //左下
        neighbors.add(new GeoHash(leftLon,bottomLat,fittingBits));
        //右下
        neighbors.add(new GeoHash(rightLon,bottomLat,fittingBits));
        return neighbors;
    }

}
class BoundingBox {
    public double minLon,minLat,maxLon,maxLat;
    BoundingBox(){

    }
    public BoundingBox(double minLongitude, double minLatitude, double maxLongitude, double maxLatitude)
    {
        this.minLon=minLongitude;
        this.minLat=minLatitude;
        this.maxLon=maxLongitude;
        this.maxLat=maxLatitude;
    }

    public Point getCenterPoint(){
        double centerLon=(minLon+maxLon)/2;
        double centerLat=(minLat+maxLat)/2;
        return new Point(centerLon,centerLat);
    }

    public double getLongitudeSize()
    {
        return maxLon-minLon;
    }

    public double getLatitudeSize()
    {
        return maxLat-minLat;
    }

    public boolean isContain(Point p)
    {
        if(p.getLon()>=minLon && p.getLon()<=maxLon && p.getLat()>=minLat && p.getLat()<=maxLat)
        {
            return true;
        }else
        {
            return false;
        }
    }
    public boolean isIntersect(BoundingBox box)
    {
        return !(box.minLon>maxLon || box.maxLon<minLon || box.minLat>maxLat || box.maxLat<minLat);
    }

    public Point getLowerLeft()
    {
        return new Point(minLon,minLat);
    }

    public Point getUpperRight()
    {
        return new Point(maxLon,maxLat);
    }
}