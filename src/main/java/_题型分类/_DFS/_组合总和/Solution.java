package _题型分类._DFS._组合总和;

import java.util.*;

/**
 * 给定一个无重复元素的数组  candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int len, int start, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len ; i ++) {

            if (target - candidates[i] < 0 ) break;

//            if (i > start  && candidates[i] == candidates[i-1]) continue;
            path.addLast(candidates[i]);
            dfs(candidates, len, i, target - candidates[i], path, res);
            path.removeLast();
        }


    }
}
