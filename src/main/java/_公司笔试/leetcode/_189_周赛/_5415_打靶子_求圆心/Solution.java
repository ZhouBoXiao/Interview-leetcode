package _公司笔试.leetcode._189_周赛._5415_打靶子_求圆心;

/**
 * 墙壁上挂着一个圆形的飞镖靶。现在请你蒙着眼睛向靶上投掷飞镖。
 *
 * 投掷到墙上的飞镖用二维平面上的点坐标数组表示。飞镖靶的半径为 r 。
 *
 * 请返回能够落在 任意 半径为 r 的圆形靶内或靶上的最大飞镖数。
 *
 *
 * 给定A(x1,y1) B(x2,y2) 以及圆心r
 * 首先就可以直接计算出垂线长度h和mid坐标(AB中点)以及AB长度d:
 *
 * d=sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
 * h=sqrt(r*r-(d/2.0)*(d/2.0))
 * mid=((x1+x2)/2.0,(y1+y2)/2.0)
 *
 * 向量a+向量b=向量c
 * 毫无疑问
 * 向量a就是mid坐标，向量b就是AB垂线的单位方向向量乘以高度h，向量c就是O坐标
 *
 * 所以现在唯一的问题就在于如何计算AB垂线的方向向量
 * 向量AB=(x3,y3) 垂线的向量即为(-y3,x3)和(y3,-x3)
 * 点积为0
 *
 * 特殊情况，AB长度大于2*r (d>2r) ，此时不存在圆心
 *
 *
 */

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/17 14:32
 */
public class Solution {
    private class Point {
        double x, y;
        Point(double x,double y) {
            this.x =x;
            this.y=y;
        }
    }
    //算两点距离
    private double dist(double x1,double y1,double x2,double y2) {
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    Point centerPoint(Point a, Point b, int r){
        Point mid = new Point((a.x+b.x)/2.0, (a.y+b.y)/2.0);
        double d = dist(a.x,a.y, mid.x,mid.y);
        double h = Math.sqrt(r*r - d*d);
        //计算垂线
        Point ba = new Point(b.x-a.x, b.y-a.y);
        Point hd = new Point(-ba.y, ba.x);
        double len = Math.sqrt(hd.x*hd.x + hd.y*hd.y);
        hd.x/=len; hd.y/=len; // 单位方向向量
        hd.x*=h;hd.y*=h;  // h 长度的向量
        return new Point(hd.x+mid.x,hd.y+mid.y);

    }
    public int numPoints(int[][] points, int r) {
        int n = points.length;
        int ans =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) { // 以当前i 点为圆心
                    int cnt = 0;
                    for (int k = 0; k < n; k++) {
                        double tmp = dist(points[i][0], points[i][1],points[k][0],points[k][1]);
                        if (tmp <= r) cnt++;
                    }
                    ans = Math.max(cnt, ans);
                } else { //两个点
                    double d=dist(points[i][0],points[i][1],points[j][0],points[j][1]);
                    if(d/2>r) continue;

                    Point a = new Point(points[i][0], points[i][1]);
                    Point b = new Point(points[j][0], points[j][1]);
                    Point res = centerPoint(a, b, r);
                    int cnt = 0;
                    for (int k = 0; k < n; k++) {
                        double tmp = dist(res.x, res.y,points[k][0],points[k][1]);
                        if (tmp <= r) cnt++;

                    }
                    ans = Math.max(cnt, ans);
                }
            }
        }
        return ans;
    }
}
