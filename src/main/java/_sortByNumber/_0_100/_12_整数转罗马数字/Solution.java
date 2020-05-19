package _sortByNumber._0_100._12_整数转罗马数字;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 11:35
 */
public class Solution {
    private static int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static String[] strings = new String[] {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    public String intToRoma1n(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - nums[i] >= 0) {
                sb.append(strings[i]);
                num -= nums[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }


    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            if (num >= 1000) {
                sb.append('M');
                num-=1000;
            } else if (num >= 500) {
                if (num >= 900) {
                    sb.append("CM");
                    num-=900;
                } else {
                    sb.append("D");
                    num-=500;
                }
            } else if (num >= 100) {
                if (num >= 400) {
                    sb.append("CD");
                    num -= 400;
                } else {
                    sb.append("C");
                    num -= 100;
                }
            } else if (num >= 50) {
                if (num >= 90) {
                    sb.append("XC");
                    num -= 90;
                } else {
                    sb.append("L");
                    num -= 50;
                }
            } else if (num >= 10) {
                if (num >= 40) {
                    sb.append("XL");
                    num -= 40;
                } else {
                    sb.append("X");
                    num -= 10;
                }
            } else if (num >= 5) {
                if (num >= 9) {
                    sb.append("IX");
                    num -= 9;
                } else {
                    sb.append("V");
                    num -= 5;
                }
            } else if (num >= 1) {
                if (num >= 4) {
                    sb.append("IV");
                    num -= 4;
                } else {
                    sb.append("I");
                    num -= 1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
    }
}
