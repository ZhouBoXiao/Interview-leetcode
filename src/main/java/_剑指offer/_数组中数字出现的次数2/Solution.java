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
}
