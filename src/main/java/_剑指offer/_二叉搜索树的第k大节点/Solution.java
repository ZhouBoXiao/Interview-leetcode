package _剑指offer._二叉搜索树的第k大节点;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur!=null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                if (--k == 0) return cur.val;
                cur = cur.left;
            }
        }
        return cur.val;
    }
}
