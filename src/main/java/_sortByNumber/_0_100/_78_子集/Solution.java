package _sortByNumber._0_100._78_子集;

import java.util.*;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 */

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0,nums);
        return res;
    }
    private void backtrack(int n, int[] nums) {
        res.add(new ArrayList<>(temp));
        for (int i = n; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

        new Solution().subsets(nums);

    }
}
