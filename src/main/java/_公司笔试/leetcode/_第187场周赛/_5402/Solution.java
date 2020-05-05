package _公司笔试.leetcode._第187场周赛._5402;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/3 10:49
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0;
        int maxLen = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(a -> a));
        while (right < nums.length) {
            map.put(nums[right], right);
            while (left < right ) {
                int min = map.firstKey(), max = map.lastKey();
                if (max- min <= limit) break;
                int temp = map.getOrDefault(nums[left], left);
                while (left <= temp) {
                    if (map.containsKey(nums[left])) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
//        if (maxLen == 0) return 0;
        return  maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{39,20,60,34,63,22,60,66,6,35,66,13,96,76,55,9,46,9,85,57,3,22,65,91,21,89,12,52,82,89,36,78,39,27,68,27,31,43,35,9,10,90,67,85,48,60,66,72,95,7,22,39,84,95,92,72,35,46,79,95,30,51,72,52,23,62,34,79,43,92,29,34,79,91,32,85,4,80,52,41,56,98,32,35,25,10,81,94,22,75,57,75,94
        };
        System.out.println(new Solution().longestSubarray(nums, 84));
    }
}
