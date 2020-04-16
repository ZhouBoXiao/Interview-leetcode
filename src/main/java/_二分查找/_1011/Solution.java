package _二分查找._1011;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        // 载重可能的最大值 + 1
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canFinish(int[] weights, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= weights[i]) >= 0) {
                i++;
                if (i == weights.length)
                    return true;
            }
        }
        return false;
    }
}
