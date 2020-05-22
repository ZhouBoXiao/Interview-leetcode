package _题型分类._DFS._79_单词搜索;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/10 23:07
 */
public class Solution {
    public class exist {
        private int[][] dires = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        private int row, col;
        private boolean hasFind;
        private boolean[][] visited;
        public boolean exist(char[][] board, String word) {
            row = board.length;
            col = board[0].length;
            hasFind = false;
            if(row * col < word.length())
                return false;
            visited = new boolean[row][col];
            char[] chars = word.toCharArray();
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(board[i][j] == chars[0]){
                        backTrack(board, chars, 1, i, j);
                        if(hasFind)
                            return true;
                    }
                }
            }
            return false;
        }

        private void backTrack(char[][] board, char[] word, int curIndex, int x, int y){
            if(hasFind)
                return;
            if(curIndex == word.length){
                hasFind = true;
                return;
            }
            visited[x][y] = true;
            for(int[] dire : dires){
                int newX = x + dire[0], newY = y + dire[1];
                if(isIn(newX, newY) && !visited[newX][newY] && board[newX][newY] == word[curIndex])
                    backTrack(board, word, curIndex + 1, newX, newY);
            }
            visited[x][y] = false;
        }

        private boolean isIn(int x, int y){
            return x >= 0 && x < row && y >= 0 && y < col;
        }
    }
}
