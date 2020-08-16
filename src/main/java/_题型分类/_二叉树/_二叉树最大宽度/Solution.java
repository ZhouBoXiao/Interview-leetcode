package _题型分类._二叉树._二叉树最大宽度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

public class Solution {
    private int maxN = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxW = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        queue.add(root);
        indexList.add(1);
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size--;
            int index = indexList.removeFirst();
            if (node.left != null) {
                queue.add(node.left);
                indexList.add(2 * index);
            }
            if (node.right != null) {
                queue.add(node.right);
                indexList.add(2 * index + 1);
            }
            if (size == 0) {
                if (indexList.size() >= 2) {
                    maxW = Math.max(maxW, indexList.getLast() - indexList.getFirst() + 1);
                }
                size = queue.size();
            }
        }
        return maxW;
    }
    public int widthOfBinaryTree1(TreeNode root) {
        dfs(root, 1, 1, new ArrayList<>());
        return maxN;
    }

    private void dfs(TreeNode root, int level, int index, ArrayList<Integer> left) {
        if (root == null) return;
        if (level > left.size())
            left.add(index);
        maxN = Math.max(maxN, index - left.get(level - 1) + 1);
        dfs(root.left, level + 1, index * 2, left);
        dfs(root.left, level + 1, index * 2 + 1, left);
    }

}
