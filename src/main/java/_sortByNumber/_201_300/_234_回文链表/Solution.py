from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        cur = slow.next
        pre = None
        while cur:
            cur, pre, cur.next = cur.next, cur, pre
        while pre:
            if head.val != pre.val:
                return False
            pre = pre.next
            head = head.next
        return True
