package _公司笔试._快手._2;

import java.util.*;

public class Solution {
    /**
     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
     * @param R int整型
     * @param N int整型 N进制
     * @return int整型一维数组
     */
    public int[] GetPowerFactor1 (int R, int N) {
        // write code here
        if (N > R) return new int[0];
        if (R == N) return new int[]{1};
        if (R % N != 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        while (R > 1) {
            cnt++;
            R /= N;
            if (R % N != 0) {
                R--;
                res.add(cnt);
                if (R % N != 0) {
                    return new int[0];
                }
            }

        }
        int[] ans = new int[res.size()];
        int index = 0;
        for (int v : res) {
            ans[index++] = v;
        }
        return ans;
    }

    public int[] GetPowerFactor (int R, int N) {

        if(R == 1) return new int[]{0};
        if(N > R) return new int[0];
        int count = 0, curr = 1;
        while (curr < R){
            curr *= N;
            count++;
        }
        if(curr == R) return new int[]{count};
        curr /= N;
        count--;
        ArrayList<Integer> res = new ArrayList<>();
        while (R >= N){
            boolean added = false;
            if (R >= curr){
                res.add(count);
                R -= curr;
                added = true;
            }
            if(added && R >= curr) return new int[0];
            curr /= N;
            count--;
        }
        if(R > 1) return new int[0];
        else if(R == 1) res.add(0);
        int[] ans = new int[res.size()];
        int j = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            ans[j++] = res.get(i);
        }
        return ans;

    }


    public static void main(String[] args) {

        int[] a = new Solution().GetPowerFactor(246, 3);
        System.out.println(a);
    }
}