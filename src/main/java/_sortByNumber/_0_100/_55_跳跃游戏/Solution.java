package _sortByNumber._0_100._55_跳跃游戏;

public class Solution {

    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length-2; i >= 0; i--) {

            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }

        }

        return true;
    }
    /*
    bool canJump(vector<int>& nums)
{
	int k = 0;
	for (int i = 0; i < nums.size(); i++)
	{
		if (i > k) return false;
		k = max(k, i + nums[i]);
	}
	return true;
}

     */
    public boolean canJump1(int[] nums) {
        int dist = 0 ;
        for (int i = 0; i < nums.length && i <= dist; i++) {
            dist = Math.max(dist, nums[i] + i);
        }
        return dist >= nums.length - 1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(new Solution().canJump(nums));
    }
}
