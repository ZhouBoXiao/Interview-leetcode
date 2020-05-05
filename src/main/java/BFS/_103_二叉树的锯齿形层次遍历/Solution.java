package BFS._103_二叉树的锯齿形层次遍历;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/4 11:10
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {

            int size = queue.size();
            //Queue<TreeNode> next = new LinkedList<>();
            List<Integer> tmp = new ArrayList<>();
            while (size-- > 0 ){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag) {
                Collections.reverse(tmp);
            }
            flag = !flag;
            res.add(tmp);
        }
        return res;

    }
}
