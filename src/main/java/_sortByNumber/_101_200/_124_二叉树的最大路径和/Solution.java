package _sortByNumber._101_200._124_二叉树的最大路径和;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

public class Solution {
    int ans = Integer.MIN_VALUE;
    /**
    * 后序遍历的思想
    *
     */
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ans;
    }

    public int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        ans = Math.max(ans, left + right + root.val); //一条路径，这条是从父节点折回去，去访问子节点
        return Math.max(left, right) + root.val; // 这条路径是选取左右最大的结点，并结合父结点返回到上层树结构
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(new Solution().maxPathSum(node));
    }

}
