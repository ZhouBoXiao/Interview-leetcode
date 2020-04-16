package 面试相关._二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

}

public class Main {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return list;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        FindPath(root, target, tmp, root.val);
        return list;
    }
    void FindPath(TreeNode root,int target, List<Integer> tmp, int cur) {

        if (root.left == null && root.right == null) {
            if (cur == target) {
                list.add(new ArrayList<>(tmp));

                return ;
            }
        }
        if (root.left != null) {
            tmp.add(root.left.val);
            FindPath(root.left, target, tmp, cur + root.left.val);
            tmp.remove(tmp.size() - 1);
        }
        if (root.right != null) {
            tmp.add(root.right.val);
            FindPath(root.right, target, tmp, cur + root.right.val);
            tmp.remove(tmp.size() - 1);
        }
    }
}
