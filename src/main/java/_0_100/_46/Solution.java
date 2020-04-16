package _0_100._46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return lists;
        boolean[] visited = new boolean[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, visited, 1, lists, list);
            list.remove(list.size()-1);
            visited[i] = false;
        }
        return lists;
    }
    void dfs(int[] nums, boolean[] visited, int i, List<List<Integer>> lists, List<Integer> list) {

        if (i == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!visited[j]) {

                visited[j] = true;
                list.add(nums[j]);
                dfs(nums, visited, i+1, lists, list);
                list.remove(list.size()-1);
                visited[j] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new Solution().permute(nums);
    }
}
