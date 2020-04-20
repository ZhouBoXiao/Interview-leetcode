package _剑指offer._矩阵中的路径;

public class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {

        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0 ; i < board.length; i ++) {
            for (int j = 0 ; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    vis[i][j] = true;
                    if (dfs(board, vis, i , j, word, 0)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
    boolean dfs (char[][] board, boolean[][] vis, int x, int y, String word, int cur) {
        if (cur == word.length() - 1) {
            return true;
        }

        for (int i = 0 ; i < 4 ; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (dx < 0 || dx >=board.length || dy < 0 || dy >= board[0].length || vis[dx][dy]) continue;

            if (cur+ 1 < word.length() && word.charAt(cur + 1) == board[dx][dy] ) {
                vis[dx][dy] = true;
                if (dfs(board, vis, dx, dy, word, cur + 1) ){
                    return true;
                }
                vis[dx][dy] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}

        };
        new Solution().exist(board,"ABCCED");
    }
}