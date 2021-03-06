package _剑指offer._和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 13:42
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int l = 1, r = 1, sum = 0; r < target; r++) {
            sum += r;
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }
        return list.toArray(new int[0][]);
    }

}