package _sortByNumber._501_600._543;


import java.util.concurrent.atomic.AtomicInteger;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMathSinglePath(root);
        return max - 1;
    }

    private int findMathSinglePath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findMathSinglePath(node.left);
        int right = findMathSinglePath(node.right);

        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int temvalue = 0;
        AtomicInteger i = new AtomicInteger(0);
        temvalue = i.getAndSet(3);
        i.set(1);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:0;  i:3
        temvalue = i.getAndIncrement();
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:3;  i:4
        temvalue = i.getAndAdd(5);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:4;  i:9
    }
}
