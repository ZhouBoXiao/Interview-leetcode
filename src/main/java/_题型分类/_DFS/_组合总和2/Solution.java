package _题型分类._DFS._组合总和2;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 */
public class Solution {
    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs1(candidates, len, 0, target, path, res);
        return res;
    }

    private void dfs1(int[] candidates, int len, int start, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len ; i ++) {

            if (target - candidates[i] < 0 ) break;

            if (i > start  && candidates[i] == candidates[i-1]) continue;
            path.addLast(candidates[i]);
            dfs1(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }


    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int start, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (start == candidates.length) return;
        int k = start + 1;
        while (k < candidates.length && candidates[k] == candidates[start] ) k++;
        int cnt = k - start;

        for (int i = 0 ;  i * candidates[start] <= target && i <= cnt ; i ++) {
            int temp = i;
            while (temp-- > 0)path.addLast(candidates[start]);
            dfs(candidates, k, target - i * candidates[start], path, res);
            temp = i;
            while (temp-- > 0) path.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
