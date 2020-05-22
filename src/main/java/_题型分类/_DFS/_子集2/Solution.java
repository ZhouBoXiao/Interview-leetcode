package _题型分类._DFS._子集2;

import java.util.*;

/**
 * 给定一组可能重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 */

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, res, list, nums.length, 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int length, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < length; i++) {
            if (i > index && nums[i-1] == nums[i]) continue;
            list.add(nums[i]);
            helper(nums, res, list, length, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
