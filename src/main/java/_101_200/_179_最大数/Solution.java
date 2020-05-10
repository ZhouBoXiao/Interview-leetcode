package _101_200._179_最大数;

import java.util.Arrays;

/**
 * @Description: 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * @Author:boxiao
 * @Data: 2020/5/9 23:09
 */
public class Solution {
    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        StringBuilder sb = new StringBuilder();
        for (String aStrArr : strArr) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        //特殊情况 若干个零
        if (result.charAt(0) == '0') {
            result = "0";
        }
        return result;
    }
}
