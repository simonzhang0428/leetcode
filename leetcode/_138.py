# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        new_head = Node(head.val)
        d = {head : new_head}
        curr = new_head
        while head:
            if head.next:
                d.setdefault(head.next, Node(head.next.val))
                curr.next = d.get(head.next)

            if head.random:
                d.setdefault(head.random, Node(head.random.val))
                curr.random = d.get(head.random)
            
            head = head.next
            curr = curr.next

        return new_head