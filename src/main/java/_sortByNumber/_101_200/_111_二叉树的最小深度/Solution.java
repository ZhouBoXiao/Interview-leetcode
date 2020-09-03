package _sortByNumber._101_200._111_二叉树的最小深度;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 1;
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node.left == null && node.right == null) return minDepth;

            if (--levelSize == 0) {
                if (queue.size() == 0) return minDepth;
                else {
                    minDepth++;
                    levelSize = queue.size();
                }
            }
        }
        return minDepth;
    }
}
