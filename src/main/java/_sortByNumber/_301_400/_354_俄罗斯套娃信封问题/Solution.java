package _sortByNumber._301_400._354_俄罗斯套娃信封问题;

import java.util.Arrays;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/12 10:23
 */
public class Solution {
    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a,b)-> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int max = 1;

        for (int i = 1 ; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);

        }
        return max;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a,b)-> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int maxL = 0;
        for (int[] en : envelopes) {
            int low = 0, high = maxL;
            while (low < high) {
                int mid = low + (high - low)/2;
                if (en[1] > dp[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            dp[low] = en[1];
            if (low == maxL) {
                maxL++;
            }
        }
        return maxL;
    }
}
