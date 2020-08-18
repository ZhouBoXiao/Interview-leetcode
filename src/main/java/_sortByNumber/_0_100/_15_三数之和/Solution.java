package _sortByNumber._0_100._15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int k = 0; k < nums.length ; k++) {

            int i = k+1 , j = nums.length - 1;

            if (k > 0 && nums[k-1] == nums[k]) continue;
            int c = -nums[k];
            while(i < j) {
                int sum = nums[i] + nums[j];
                if ( sum == c) {
                    res.add(Arrays.asList(nums[k] , nums[i], nums[j]));
                    i++;
                    while (i < j && nums[i] == nums[i-1]) i++;
                    j--;
                    while (i < j && nums[j] == nums[j+1]) j--;
                } else if ( sum > c) {
                    j--;
                    while (i < j && nums[j] == nums[j+1]) j--;
                } else {
                    i++;
                    while (i < j && nums[i] == nums[i-1]) i++;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        new Solution().threeSum(nums);
    }
}
