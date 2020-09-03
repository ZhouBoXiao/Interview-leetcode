package _sortByNumber._101_200._148_链表排序;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class Solution {
    public ListNode sortList(ListNode head) {

        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode p = head, q = head, pre= null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);

        return merge1(l, r);
    }
    private ListNode merge1(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;
        if (l.val <= r.val) {
            l.next = merge1(l.next, r);
            return l;
        } else {
            r.next = merge1(l, r.next);
            return r;
        }
    }
    private ListNode merge(ListNode l, ListNode r) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        while (l != null && r != null) {
            if(l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else{
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return temp.next;
    }

    public ListNode sortList1(ListNode head) {
        if(head==null||head.next==null) return head;
        // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        return quickSort(newHead,null);
    }
    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head,ListNode end){
        if (head==end||head.next==end||head.next.next==end) return head;
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead = new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition = head.next, p = partition, tp = tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next != end){
            if (p.next.val < partition.val){
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next = head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next = tmpHead.next;
        quickSort(head, partition);
        quickSort(partition, end);
        // 题目要求不带头节点，返回结果时去除
        return head.next;
    }

}
