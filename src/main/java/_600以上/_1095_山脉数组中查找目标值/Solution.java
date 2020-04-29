package _600以上._1095_山脉数组中查找目标值;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/29 20:28
 */

interface MountainArray {
    public int get(int index);

    public int length();
}
class Helper implements MountainArray {
    int[] nums = new int[]{0,5,3,1};
    @Override
    public int get(int index) {
        return nums[index];
    }

    @Override
    public int length() {
        return nums.length;
    }
}
public class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0, right = len -1, peak = 0;
        while (left<= right) {
            int m = left + (right - left) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                left = peak = m + 1;
            } else {
                right = m - 1;
            }
        }
        if (mountainArr.get(peak) == target) return peak;
        int index = binary_search1(mountainArr, target, 0, peak);
        if (index != -1)
            return index;
        return binary_search2(mountainArr, target, peak +1, len - 1);
    }
    int binary_search1(MountainArray mountain, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = mountain.get(mid);
            if (cur == target)
                return mid;
            else if (cur < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
    int binary_search2(MountainArray mountain, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = mountain.get(mid);
            if (cur == target)
                return mid;
            else if (cur < target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        new Solution().findInMountainArray(1, new Helper());
    }

}
