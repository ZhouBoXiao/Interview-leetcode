package _剑指offer._二叉树中和为某一值的路径;

import  java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) return lists;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        dfs(root, temp, root.val, sum);
        return lists;
    }

    void dfs(TreeNode node, List<Integer> list, int total, int sum) {
        //if (total > sum) return;

        if (total == sum && node.right == null && node.left == null) {
            lists.add(new ArrayList<>(list));
            return ;
        }

        if (node.left != null) {
            list.add(node.left.val);
            dfs(node.left, list, total+node.left.val, sum);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            list.add(node.right.val);
            dfs(node.right, list, total+node.right.val, sum);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode right = new TreeNode(-3);
        root.right = right;

        new Solution().pathSum(root, -5);
    }
}
