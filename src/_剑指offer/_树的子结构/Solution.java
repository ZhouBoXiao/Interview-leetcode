package _剑指offer._树的子结构;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}

}

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    boolean isSubTree(TreeNode A, TreeNode B) {

        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
        } else {
            return false;
        }
    }
}
