package _题型分类._蓄水池抽样._链表随机节点;

import java.util.Random;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/11 11:18
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random r = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        while (p != null) {
            if (r.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
