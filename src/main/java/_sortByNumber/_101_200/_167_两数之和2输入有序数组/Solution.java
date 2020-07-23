package _sortByNumber._101_200._167_两数之和2输入有序数组;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/23 20:40
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; j < numbers.length; i++) {
            while (j > i && numbers[j] + numbers[i] > target) j--;
            if (numbers[i] + numbers[j] == target) return new int[]{i+1,j+1};
        }
        return new int[]{-1,-1};
    }
}
