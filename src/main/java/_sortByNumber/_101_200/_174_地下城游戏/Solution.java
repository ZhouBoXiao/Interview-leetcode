package _sortByNumber._101_200._174_地下城游戏;

/**
 * @Description:
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *
 *
 * @Author:boxiao
 * @Date: 2020/7/12 13:37
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col -1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == row - 1) {
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                } else if (j == col - 1) {
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
/**
 * 拟录用，按以下意见和附件模板修改后转编辑加工处理。
 *
 * 1、篇幅太长，请删至9页以内，曲线图水平轴长保持4.0cm，图中文字为6号字。文献中作者姓的字母全部大写，中国人名字用全拼，会议录文献补充会议地（城市、国家）。
 *
 * 2、建议引用电子与信息学报近两年发表的相关论文2篇,按照网站上的论文模板检查参考文献格式，补齐缺项。
 *
 * 尽快返回修改稿和修改说明。
 */