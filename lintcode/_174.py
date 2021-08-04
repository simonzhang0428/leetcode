"""
Definition of ListNode
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

17.17 -
         W        R
D->1->2->3->4->5->null, n = 2
D->1->2->3->5->null
let Runner move n+1 step, then move Walker and Runner until R hit null
lint W.next = W.next.next
return dummy.next

W              R
dummy -> 1 -> null   n = 1
null
"""

class Solution:
    """
    @param head: The first node of linked list.
    @param n: An integer
    @return: The head of linked list.
    """
    def removeNthFromEnd(self, head, n):
        # write your code here
        dummy = ListNode(0)
        dummy.next = head
        walker = dummy
        runner = dummy
        for _ in range(n+1):
            runner = runner.next
        while runner:
            walker = walker.next
            runner = runner.next
        walker.next = walker.next.next

        return dummy.next
