package _剑指offer._数组中数字出现的次数2;

public class Solution {
    public int singleNumber(int[] nums) {
        int a =0  ,b = 0;
        for (int i =0; i < nums.length; i++) {
            a =  a ^ nums[i] & ~b;
            b = b ^ nums[i] & ~ a;
        }
        return a;
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (((1<<i) & num ) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 != 0) {
                res += (1<<i);
            }
        }
        return res;
    }
}
