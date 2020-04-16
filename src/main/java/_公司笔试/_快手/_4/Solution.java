package _公司笔试._快手._4;

import java.util.*;

public class Solution {

    public int GetMaxStaffs (char[][] pos) {
        // write code here

        int m = pos.length, n = pos[0].length;
        int res = 0;
        map = pos;
        visited = new boolean[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && pos[i][j] == '.'){
                    count = 0;
                    mov(m, n, i, j);
                    if(count % 2 == 0) res += (count / 2);
                    else res += (count / 2) + 1;
                }else visited[i][j] = true;
            }
        }
        return res;
    }
    private int count = 0;
    private boolean[][] visited = null;
    private char[][] map = null;
    private void mov(int rows, int cols, int row, int col) {
        if(row >= rows || col >= cols || visited[row][col]) return;
        if(map[row][col] == '*'){
            visited[row][col] = true;
            return;
        }
        visited[row][col] = true;
        char curr = map[row][col];
        count++;
        if(row > 0) mov(rows, cols, row - 1, col);
        if(row < rows - 1) mov(rows, cols, row + 1, col);
        if(col > 0) mov(rows, cols, row, col - 1);
        if(col < cols - 1) mov(rows, cols, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] pos = new char[][]{
                {'*','.','*','*','.'},{'*','.','*','*','*'},{'*','.','*','*','.'}
        };
        new Solution().GetMaxStaffs(pos);
    }
}
