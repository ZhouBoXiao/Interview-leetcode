package _sortByNumber._101_200._134_加油站;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/24 22:37
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i =0, j = 0;
        int n = gas.length;
        for (i =0 ; i < n; i += j + 1) {
            int gas_left = 0;
            for (j = 0; j < n; j++) {
                int k = (i + j) % n;
                gas_left += gas[k] - cost[k];
                if (gas_left < 0) {
                    break;
                }
            }
            if (j >= n) return i;
        }
        return -1;
    }
}
