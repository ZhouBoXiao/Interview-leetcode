package _题型分类._二叉树._找完全二叉树最底层最右边的结点;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/3 23:22
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


public class Solution {
    // 算法时间复杂度为log(n)
    TreeNode getTarget(TreeNode root, int n) {
        if (root == null) return root;

        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 2);
            n /= 2;
        }
        Collections.reverse(list);
        for (int i : list) {
            root = i == 0 ? root.left : root.right;
        }
        return root;
    }
}
