class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
from typing import Optional

'''给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。'''
class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast, slow = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow ==  fast:
                ans = head
                while ans != slow:
                    ans = ans.next
                    slow = slow.next
                return ans