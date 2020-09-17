package _sortByNumber._0_100._77_组合;

import java.util.*;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/8 9:59
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0|| k<= 0||k>n){
            return res;
        }

        List<Integer> temp = new ArrayList<>();

        dfs(res, temp, n, k, 1);

        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> temp, int n, int k, int i) {
        if (temp.size() == k)  {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j <= n - (k - temp.size()) + 1; j++) {
            temp.add(j);
            dfs(res, temp, n, k, j + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
