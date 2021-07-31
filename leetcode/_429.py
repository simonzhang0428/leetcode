# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
11:23 - 11:36   7/30

high level: BFS, level order traversal
mid level: queue store cur level res, for the popped node, for its all children, add them to queue

test:
size = 2
cur_res = [5, 6]
q = []
cur = 6
res = [[1], [3, 2, 4], [5, 6]]

time: O(# of nodes) -> O(n)
space:O(max(width of nodes)) ->O(n)
"""
from collections import deque
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        if not root:
            return res

        queue = deque([root])
        while queue:
            size = len(queue)
            cur_res = []
            for _ in range(size):
                cur = queue.popleft()
                cur_res.append(cur.val)
                for child in cur.children:
                    queue.append(child)
            res.append(cur_res)
        
        return res