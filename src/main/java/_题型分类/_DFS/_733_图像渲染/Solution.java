package _题型分类._DFS._733_图像渲染;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/20 12:12
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origColor = image[sr][sc];
        fill(image, sr, sc, origColor, newColor);
        return image;
    }
    void fill(int[][] image, int x, int y, int origColor, int newColor) {
        if (!inArea(image, x, y)) return;
        if (image[x][y] != origColor) return;

        if (image[x][y] == -1) return;

        image[x][y] = -1;
        fill(image, x, y + 1, origColor, newColor);
        fill(image, x, y - 1, origColor, newColor);
        fill(image, x - 1, y, origColor, newColor);
        fill(image, x + 1, y, origColor, newColor);
        image[x][y] = newColor;
    }

    boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && y >= 0 && x < image.length && y < image[0].length;
    }
}
