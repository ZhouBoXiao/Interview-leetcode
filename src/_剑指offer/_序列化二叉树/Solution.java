package _剑指offer._序列化二叉树;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)  {return "null";}
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        str.append(root.val).append(",");

        while (!queue.isEmpty()) {
            for(int i = queue.size();i > 0; --i){
                TreeNode node = queue.poll();
                if (node.left == null) {
                    str.append("null,");
                } else  {
                    queue.offer(node.left);
                    str.append(node.left.val).append(",");
                }
                if (node.right == null) {
                    str.append("null,");
                } else {
                    queue.offer(node.right);
                    str.append(node.right.val).append(",");
                }
            }
        }
        return str.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        if("null".equals(data)) return null;
        String[] node = data.split(","); //分割层
        Queue<TreeNode> queue = new LinkedList(); //辅助队列
        TreeNode root=new TreeNode(Integer.parseInt(node[0])); //初始化队列
        queue.add(root);
        int i=1;
        while (i < node.length) {
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode q = queue.poll();
                if ("null".equals(node[i])) q.left=null;
                else {
                    q.left = new TreeNode(Integer.parseInt(node[i]));
                    next.offer(q.left);
                }
                i++;
                if ("null".equals(node[i])) q.right=null;
                else {
                    q.right = new TreeNode(Integer.parseInt(node[i]));
                    next.offer(q.right);
                }
                i++;
            }
            queue = next;
        }
        return root;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.serialize(solution.deserialize("1,2,3,null,null,4,5,null,null,null,null,")));


    }


}
