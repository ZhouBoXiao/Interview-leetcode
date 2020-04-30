package _201_300._202;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 15:25
 */
public class Solution {
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
    private int getNext(int n) {
        int sum =0 ;
        while (n > 0) {
            int t = n%10;
            sum += t*t;
            n/=10;
        }
        return sum;
    }
}
