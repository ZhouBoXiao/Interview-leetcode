package _题型分类._二叉树._二叉树的序列化与反序列化;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)  {return "null";}
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        str.append(root.val).append(",");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                str.append(node.left.val).append(",");
            } else {
                str.append("null").append(",");
            }
            if (node.right != null) {
                queue.offer(node.right);
                str.append(node.right.val).append(",");
            } else {
                str.append("null").append(",");
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) return null;
        if("null".equals(data)) return null;
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < strs.length;) {

            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if ("null".equals(strs[i])) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(strs[i]));
                    next.offer(node.left);
                }
                i++;
                if ("null".equals(strs[i])) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(strs[i]));
                    next.offer(node.right);
                }
                i++;
            }
            queue = next;
        }
        return root;
    }


}
