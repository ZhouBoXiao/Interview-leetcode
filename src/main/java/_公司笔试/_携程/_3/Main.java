package _公司笔试._携程._3;

import java.util.*;

/**
 * 将一个数组划分成M部分，要求每一部分子数组的sum不能重复，求有多少种方案
 */
public class Main {
    static int cnt = 0;
    static int[] sum;
    static List<Integer> plan = new ArrayList<>();

    static void dfs (int n, int m) {
        if (m == 0) {
            if (n == 0) {
                if (judge(plan)) {
                    cnt++;
                }
            }
        }
        for (int i = 1; i <= n ; i++) {
            plan.add(i);
            dfs(n - i, m - 1);
            plan.remove(plan.size() - 1);
        }
    }

    private static boolean judge(List<Integer> plan) {
        Set<Integer> s = new HashSet<>();
        int preCnt = 0;
        for (int x: plan) {
           int S = sum[preCnt + x] - sum[preCnt];
           if (s.contains(S)) {
               return false;
           }
           s.add(S);
           preCnt+=x;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _nums_size = 0;
        _nums_size = Integer.parseInt(in.nextLine().trim());
        int[] _nums = new int[_nums_size];
        int _nums_item;
        for(int _nums_i = 0; _nums_i < _nums_size; _nums_i++) {
            _nums_item = Integer.parseInt(in.nextLine().trim());
            _nums[_nums_i] = _nums_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());
        if (_nums_size < _m) {
            System.out.println(0);
            return;
        }
        sum = new int[_nums_size + 1];

        for (int i = 1; i <= _nums_size; i++) {
            sum[i] = sum[i - 1] + _nums[i - 1];
        }
        dfs(_nums_size, _m);
        System.out.println(String.valueOf(cnt));

    }
}