package _题型分类._链表.删除排序链表中的重复元素2;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/19 15:39
 */

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates1(head.next);
        if (head.val == head.next.val) head = head.next;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
