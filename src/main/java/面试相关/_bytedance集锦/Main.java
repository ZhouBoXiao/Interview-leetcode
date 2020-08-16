package 面试相关._bytedance集锦;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/16 18:06
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
}

class ListNode{
    ListNode next;
    int val;
    ListNode(int val) {
        this.val = val;
    }
}
public class Main {
    /**
     * 由 rand3() 来求 rand5
     *
     * @return
     */
    int rand3() {
        return 0;
    }

    public int rand5() {
        while (true) {
            int num = rand3() + (rand3() - 1) * 3;
            if (num <= 5) {
                return num;
            }
            num = (num - 5) * 3 + rand3();
            return 1 + (num - 1) % 5;
        }
    }

    /**
     * 判断为BST
     */
    public boolean isBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;

        int val = root.val;
        if (low != null && low > val) return false;
        if (high != null && high < val) return false;

        if (!check(root.left, low, val)) return false;
        if (!check(root.right, val, high)) return false;

        return true;
    }

    /**
     * 合并两个有序链表
     */
    public ListNode mergeKLists1(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    /**
     * K个一组翻转链表
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b==null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        while (a != b) {
            ListNode next = a.next;
            a.next = pre;
            pre = a;
            a = next;
        }
        return pre;
    }

    /**
     * 无序数组中第k大的数
     * @return
     */
    public int findKthLargest1(int[] nums, int k){
        // k是要求的第几大(从1开始计数),k-1即是数组中的序号(0开始计数)
        return findKthLargest(nums,0,nums.length-1,k-1);
    }
    public int findKthLargest(int[] nums,int low,int high,int k){
        int index = partition(nums,low,high);
        if (index == k)
            return nums[index];
        else if (index>k)
            return findKthLargest(nums,low,index-1,k);
        else
            return findKthLargest(nums,index+1,high,k);
    }

    // 找第k 大 的数就把数组按大->小排列
    private int partition(int[] nums,int left,int right){
        int temp = left;
        while (left < right){
            while (left < right && nums[right] <= nums[temp]) right--;
            while (left < right && nums[left] >= nums[temp]) left++;
            swap(nums, left, right);
        }
        swap(nums, temp, right);
        return right;
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 二叉树中的最大路径和
     */

    int ans = Integer.MIN_VALUE;

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

    /**
     *  堆排序
     */
    void sort(int[] arr) {
        for (int i = arr.length/2 - 1; i >= 0 ; i--) {
           adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Main().findKthLargest1(new int[]{1, 2, 3, 4, 5, 6}, 2));
    }
}