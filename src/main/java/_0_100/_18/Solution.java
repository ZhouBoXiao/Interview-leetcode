package _0_100._18;
import java.util.*;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);

        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a-1] == nums[a]) continue;
            if (nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break;
            for (int b = a+1; b <nums.length - 2; b++) {
                int t = target - nums[a] - nums[b];
                int c = b+1, d = nums.length - 1;
                if (b > a+1 && nums[b-1] == nums[b]) continue;
                while (c < d) {
                    int sum = nums[c] + nums[d];

                    if (sum == t) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while(c<d && nums[c] == nums[++c]);
                        while(c<d && nums[d] == nums[--d]);
                    } else if (sum > t) {
                        d--;
                    } else {
                        c++;

                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0,0,0,0};
        new Solution().fourSum(nums, 0);
    }
}