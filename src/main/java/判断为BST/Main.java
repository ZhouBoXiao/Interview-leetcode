package 判断为BST;



import java.util.*;

class TreeNode{

    TreeNode left,right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(",");

        if ("None".equals(str[0])){
            System.out.println("True");
            return;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        buildTree(str, root);
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);

        for (int i = 1 ; i < list.size(); i++){
            if ((list.get(i-1) > list.get(i))){
                System.out.println("False");
                return;
            }
        }

        System.out.println("True");
    }

    private static void buildTree(String[] str, TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i<str.length; i++){
            TreeNode temp = new TreeNode(Integer.parseInt(str[i]));

            queue.add(temp);

            if (root.left == null) {
                root.left = temp;

            }
            else {
                root.right = temp;
                queue.poll();
                root = queue.peek();
            }


        }
    }

    static void inOrder(TreeNode root, List<Integer> list){
        if(root!=null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
