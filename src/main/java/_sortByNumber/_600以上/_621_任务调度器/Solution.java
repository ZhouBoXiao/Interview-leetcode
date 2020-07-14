package _sortByNumber._600以上._621_任务调度器;

import java.util.Arrays;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/7/12 16:40
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[25] != count[i]) {
                break;
            }
            maxCount++;
        }
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + maxCount);
    }
}
