package _201_300._260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int num1 = 0, num2 = 0;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor & (~xor + 1);
        for (int num : nums) {
            if ((num & diff) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
