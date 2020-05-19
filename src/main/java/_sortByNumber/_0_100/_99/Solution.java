package _sortByNumber._0_100._99;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
public class Solution {
    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
    //中序遍历过程中，记录错误两个错误排序节点，最后进行交换
    //只需要中序遍历一遍就可以了
    //我们对错误的二叉树进行 中序遍历 那我们按顺序访问到的数应该是按顺序排列的
    //那如果对两个节点交换了顺序  那一定有 两个 地方是  不满足  前一个元素 < 当前元素 < 后一个元素
    void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        if (pre != null &&  node.val < pre.val) {
            if (t1 == null) t1 = pre;
            t2 = node;
        }
        pre = node;
        traverse(node.right);

    }
}
