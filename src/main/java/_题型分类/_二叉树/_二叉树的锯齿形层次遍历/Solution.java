package _题型分类._二叉树._二叉树的锯齿形层次遍历;

import io.netty.handler.codec.dns.AbstractDnsOptPseudoRrRecord;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/2 13:50
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
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);

        }
        return res;

    }
}
