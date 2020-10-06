package _sortByNumber._0_100._90_子集2;

import java.util.*;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/18 21:55
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
