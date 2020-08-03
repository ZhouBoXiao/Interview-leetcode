package _剑指offer._数组中数字出现的次数;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum  = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum ^= nums[i];
        }
        int flag = sum & (-sum);  //得到sum的二进制的1的最低位想·x`
        int[] res = new int[2];
        for (int i = 0 ; i < nums.length; i++) {
            if ((flag & nums[i] ) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
