package _剑指offer._删除链表的节点;

class ListNode{

    int val;

    ListNode next;
    ListNode(int  x) {val = x;}
}

public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur!=null && cur.next!=null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return pre.next;
    }

    public void deleteNode3(ListNode head, ListNode val) {
        if (head == null) return;//链表为空，直接返回

        if (val.next != null) {//需要删除的节点后面还有节点时，此时链表中最少有两个节点
            val = val.next;  //如果val本身就不在链表内，则该语句对链表没有影响，链表不变。
            return;
        }
        //需要删除的节点后面没有节点时，即要删除的节点位于尾节点
        //这时有两个情况：1.链表中只有这一个节点，此时删除后链表为null。2.需要删除的节点前面还有节点。
        if(head.next==null) {
            if(head==val) {    //head.val==val.val可能会有问题
                head = null;//链表中只有一个节点，且为需要删除的节点时，head=null,若不是需要删除的节点，则链表不变
                return;
            }
            return;//只有一个节点，但是不是要删除的节点，则直接返回，链表不变。
        }
        //下面剩下的就是链表中节点大于1，且要删除的节点位于尾节点,这部分代码和deleteNode1部分代码基本一致。
        //if(head.val==val.val) head=head.next; //这句可以不加，此时要删除的节点不可能位于头部
        ListNode cur =head;
        while(cur.next!=null&&cur.next!=val) { //这里cur.next.val!=val.val可能会有问题
            cur=cur.next;
        }
        if(cur.next!=null) cur.next=cur.next.next;
        //而如果是cur.next==null导致的跳出循环，则说明链表中查询完毕也没有找到对应节点，不对链表进行修改。
        return;

    }

/*    //如果输入的类型为 head: ListNode, val: ListNode，val是一个链表节点
//时间O(1)，空间O(1)
    class Solution {
        public:
        ListNode* deleteNode(ListNode* head, int val) {
            if(head == NULL || val == NULL || head == val)return NULL;
            if(val->next != NULL){//待删节点不是尾节点
                ListNode* tmp;
                tmp = val->next;
                val->val = tmp->val;//O(1)
                val->next = tmp->next;
            }else{//待删除节点是尾节点
                ListNode* cur;
                cur = head;
                while(cur->next != val){cur = cur->next;}
                cur->next = NULL;
            }
            return head;
        }
    };*/

}
