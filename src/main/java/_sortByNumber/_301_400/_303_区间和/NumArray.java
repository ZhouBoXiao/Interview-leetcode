package _sortByNumber._301_400._303_区间和;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/10 10:43
 */
public class NumArray {

    private int[] sums;
    public NumArray(int[] nums) {
        sums = new  int[nums.length + 1];
        if (nums.length == 0) return;
        //sums[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] += sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];

    }
}
