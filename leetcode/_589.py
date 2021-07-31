# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
11:15 - 11:23
preorder: root - left - right
                1
            /   \   \
            3   2   4
          /   \
         5     6

res = [1, 3, 5, 6, 2, 4]
high level: recursion
base case: leaf node, return
recursive rule: add root.val to res, for each branch go deeper
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        self.helper(root, res)
        return res

    def helper(self, root, res):
        if not root:
            return
        res.append(root.val)
        for child in root.children:
            self.helper(child, res)