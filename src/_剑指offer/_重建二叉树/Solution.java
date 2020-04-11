package _剑指offer._重建二叉树;

import java.util.Arrays;
import java.util.HashMap;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;
        TreeNode root = new TreeNode(po[pre_root]);
        int i = dic.get(po[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        if (n == 0) return null;
//        int rootIndex = 0;
//        for (int i = 0; i < n; i++) {
//            if (inorder[i] == preorder[0]) {
//                rootIndex = i;
//                break;
//            }
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex),
//                Arrays.copyOfRange(inorder, 0, rootIndex));
//        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n),
//                Arrays.copyOfRange(inorder, rootIndex + 1, n));
//        return root;
//    }
}
