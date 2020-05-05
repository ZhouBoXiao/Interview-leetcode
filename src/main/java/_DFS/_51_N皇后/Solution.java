package _DFS._51_N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/4 22:57
 */
public class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n ;i ++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0);
        return res;
    }
    private static List<String> charToString(char[][] array) {
        List<String> result = new ArrayList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }
    void backtrack(char[][] board, int row) {
        // 触发结束条件
        if (row == board.length) {
//            res.push_back(board);
            res.add(charToString(board));
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col))
                continue;
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }
    /* 是否可以在 board[row][col] 放置皇后？ */
    boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
class Solution1{
    private int size;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        size = (1 << n) - 1;
        char[][] queens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(queens[i], '.');
        }

        dfs(0, 0, 0, queens, 0, n);
        return res;
    }

    private void dfs(int row, int ld, int rd, char[][] queens, int level, int n) {
        if (row == size) {
            res.add(generate(queens));
            return;
        }

        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos); // 得到最后一位1
            pos -= p;
            int idx = getPos(p, n);
            queens[level][idx] = 'Q';
            dfs(row | p, (ld | p) << 1, (rd | p) >> 1, queens, level + 1, n);
            queens[level][idx] = '.';
        }
    }

    private List<String> generate(char[][] queens) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            res.add(String.valueOf(queens[i]));
        }
        return res;
    }

    private int getPos(Integer queen, int size) {
        for (int i = 0; i < size; i++) {
            if (((1 << i) ^ queen) == 0) { // 1<<i - queen
                return i;
            }
        }
        return 0;
    }
}