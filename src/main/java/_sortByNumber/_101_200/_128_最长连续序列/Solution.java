package _sortByNumber._101_200._128_最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/18 23:00
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        int max = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                longest =0 ;
                int cur = 1;
                while (set.remove(num-cur)) cur++;
                longest += cur;
                cur = 1;
                while (set.remove(num+cur)) cur++;
                longest += cur;
                max = Math.max(max, longest-1);
            }

        }
        return max;
    }
}
