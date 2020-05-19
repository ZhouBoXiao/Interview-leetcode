package _sortByNumber._101_200._199;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

/**
 * 二叉树的右视图
 */
public class Solution {
    List<Integer> ans = new ArrayList<>();
    int deepest = 0;

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int now) {
        if (root == null) return;
        if (now == deepest) {
            ans.add(root.val);
            deepest++;
        }
        helper(root.right, now + 1);
        helper(root.left, now + 1);
    }
    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().val);
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.right != null ){
                    q.offer(node.right);
                }
                if (node.left != null){
                    q.offer(node.left);
                }

            }
        }
        return res;
    }*/
}
