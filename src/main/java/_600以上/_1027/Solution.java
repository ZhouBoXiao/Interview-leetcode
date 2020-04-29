package _600以上._1027;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/29 18:15
 */
public class Solution {
    public int longestArithSeqLength(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int d = A[i] - A[j];
                int cnt = 2 ;
                int pre = A[j];
                for (int k = j + 1; k < A.length; k++) {
                    if (pre - A[k] == d) {
                        cnt++;
                        pre = A[k];
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().longestArithSeqLength(new int[]{3,6,9,12});

    }
}
