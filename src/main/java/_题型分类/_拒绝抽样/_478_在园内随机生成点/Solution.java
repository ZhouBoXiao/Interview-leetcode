package _题型分类._拒绝抽样._478_在园内随机生成点;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/11 16:46
 */
public class Solution {
    double x,y,radius;
    public Solution(double radius, double x_center, double y_center) {
        x = x_center;
        y = y_center;
        this.radius = radius;
    }

    public double[] randPoint() {
        double r = Math.sqrt(Math.random() * radius * radius);
        double theta = Math.PI * 2 * Math.random();
        double rx = Math.cos(theta) * r + x;
        double ry = Math.sin(theta) * r + y;
        return new double[]{rx, ry};
    }
}
