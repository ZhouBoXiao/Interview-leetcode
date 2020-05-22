package _题型分类._DFS._52_N皇后2;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/4 22:57
 */
public class Solution {
    private int count = 0;
    private int size;
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        size = (1 << n) - 1;
        dfs(0, 0, 0, 0, n);
        return count;
    }
    private void dfs(int row, int ld, int rd, int level, int n) {
        if (row == size) {
            count++;
            return;
        }

        int pos = size & (~(row | ld | rd)); // 获取当前空位 标识为1
        while (pos != 0) {  //遍历所有空位
            int p = pos & (-pos); //获取最后的空位 1
            pos -= p;  // 打掉最后的1
            int idx = getPos(p, n);

            /**
             col | p 表示 p 位被占用
             (pie | p ) << 1 ,表示pie往斜左方移一位 被占用
             (na | p) >> 1,表示na往斜右方移一位 被占用
             **/
            dfs(row | p, (ld | p) << 1, (rd | p) >> 1, level + 1, n);
        }
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