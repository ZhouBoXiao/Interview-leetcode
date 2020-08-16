package 面试相关.b1.b5;


import javafx.util.Pair;

import java.util.*;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

public class Main {
    Map<String, Integer> map =new HashMap<>();
    int[][] dataNum;
    int[][] grid;
    public Map<String, Integer> storeTrueDataNum() {

        for (int i = 0; i <dataNum.length ; i++) {
            for (int j = 0; j <dataNum[i].length ; j++) {
//                int [][] num = new int[1][2];
                if (dataNum[i][j] == 1){
//                    num[0][0]=i;
//                    num[0][1]=j;
                    String temp = i + "," + j ;
                    map.put(temp,1);

                }else {
                    /**
                     * 四叉树
                     */
                    grid[i][j] = 1;
                    Node temp = fun(grid,0,grid[0].length,0,grid.length);

                }
            }
        }
        return map;
    }

    void init(){
        Random random = new Random(System.currentTimeMillis());
        int r = random.nextInt(10000);
        int size = (int)(Math.sqrt(r));
        dataNum = new int[size][size];
        grid = new int[size][size];
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j ++){
                dataNum[i][j] = random.nextInt(2); //随机 产生 0 -1
            }
        }

    }

    public Node fun(int[][] grid,int left,int right,int top,int bottom){
        Node root = null;
        int key = grid[top][left];
        for(int i = top; i < bottom; i++){
            for(int j=left;j<right;j++){
                if(grid[i][j]!=key){
                    Node topLeft = fun(grid,left,(left+right)/2,top,(top+bottom)/2);
                    Node topRight = fun(grid,(left+right)/2,right,top,(top+bottom)/2);
                    Node bottomLeft = fun(grid,left,(left+right)/2,(top+bottom)/2,bottom);
                    Node bottomRight = fun(grid,(left+right)/2,right,(top+bottom)/2,bottom);
                    root = new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
                    return root;
                }
            }
        }
        root = new Node();
        root.val = key == 1;
        root.isLeaf = true;
        return root;
    }

    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
        main.init();
        main.storeTrueDataNum();
    }
}


class QuadTreeNode {
    int x,y;
    QuadTreeNode topLeft;
    QuadTreeNode topRight;
    QuadTreeNode bottomLeft;
    QuadTreeNode bottomRight;
    QuadTreeNode root;

    public QuadTreeNode(int x, int y){
        this.x = x;
        this.y = y;
    }

    void insert(Pair<Integer, Integer> node, QuadTreeNode cur) {

        if (node.getKey() > cur.x && node.getValue() > cur.y) { // 右上 topRight
            if (cur.topRight == null) {
                cur.topRight = new QuadTreeNode(node.getKey(), node.getValue());
            } else {
                insert(node, cur.topRight);
            }
        } else if (node.getKey() > cur.x && node.getValue() < cur.y) {    // 右下
            if (cur.bottomRight == null) {
                cur.bottomRight = new QuadTreeNode(node.getKey(), node.getValue());
            } else {
                insert(node, cur.bottomRight);
            }
        } else if (node.getKey() < cur.x && node.getValue() > cur.y) {   //左上
            if (cur.topLeft == null) {
                cur.topLeft = new QuadTreeNode(node.getKey(), node.getValue());
            } else {
                insert(node, cur.topLeft);
            }
        } else if (node.getKey() < cur.x && node.getValue() < cur.y){  // //左下
            if (cur.bottomLeft == null) {
                cur.bottomLeft = new QuadTreeNode(node.getKey(), node.getValue());
            } else {
                insert(node, cur.bottomLeft);
            }
        }
    }

    public void buildTree(){
        List<Pair<Integer, Integer>> list  = new ArrayList<>();
         //
        root = new QuadTreeNode(list.get(0).getKey(), list.get(0).getValue());

        for (int i = 1; i <list.size() ; i++) {
            insert(list.get(i), root);
        }
    }

}

/*class Node {
    private double dis;
    private int index;
    public Node(double dis,int index){
        this.dis=dis;
        this.index=index;
    }

    public void setIndex(int index){
        this.index=index;
    }

    public int getIndex(){
        return  index;
    }

    public void setDis(double dis){
        this.dis = dis;
    }

    public double getDis(){
        return dis;
    }
}*/

class Point implements Comparable<Point> {
    private int index;
    private double x;
    private double y;
    private double dis;
    private String key;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Point(String key, int index, double x, double y) {
        this.key = key;
        this.index = index;
        this.x = x;
        this.y = y;
        this.dis = setDis(x, y);

    }

    private double setDis(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * 计算两点间的距离
     */

    public static double setDist(Point point0, Point point1) {
        return Math.sqrt((point0.x - point1.x) * (point0.x - point1.x) +
                (point0.y - point1.y) * (point0.y - point1.y));
    }
    /*根据点到查询点的距离判断点的大小重写compareTo（）
     *
     */

    public int compareTo(Point point) {
        return Double.compare(dis, point.dis);
    }

    /**
     * 判断两个点是否相同，重写equals()
     */
    public boolean equals(Point point) {
        //检测this和otherObject是否引用同一个对象
        if (this == point)
            return true;
        //检测otherObject检测点是否为空
        if (point == null) {
            return false;
        }
        //比较this和otherObject是否属于同一个类
        if (this.getClass() != point.getClass())
            return false;
        //将otherObject转化为同一个类型的变量
        Point other = (Point) point;
        //比较所有区域
        return key.equals(other.key) && index == other.index
                && x == other.x && y == other.y && dis == other.dis;
    }
}
