package _题型分类._贪心._45_跳跃游戏2;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/4 10:43
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextreach = Math.max(i + nums[i], nextreach);
            if (nextreach >= nums.length - 1) return step+1;
            if (i == reach) {
                step++;
                reach = nextreach;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        new Solution().jump(new int[]{2,2,1,1,4});
    }
}
