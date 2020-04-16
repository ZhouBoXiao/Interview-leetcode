package _二分查找._875_爱吃香蕉的珂珂;

public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1000000000;
        while(lo < hi){
            int mi = (lo + hi) / 2;
            if(serchTargetK(piles, H, mi)){
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;

    }

    public boolean serchTargetK(int[] piles, int H, int K){
        int time = 0;
        for (int pile : piles){
            // consider the equal case
            time = (pile-1) / K + 1 + time;
        }
        return time <= H;
    }
}
