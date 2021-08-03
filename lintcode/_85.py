"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

10:29 - 10:48
input: root, target, both TreeNode
output: root after insertion

Recursion: 
1. we need track root node to insert (iterative way)
2. utilize BST property to move left or right

time: O(height)
space: O(1) == in-place

          10    node = 12
        /   \
        5    15
            /
            12
test:
"""


class Solution:
    """
    @param: root: The root of the binary search tree.
    @param: node: insert this node into the binary search tree
    @return: The root of the new binary search tree.
    """
    def insertNode(self, root, node):
        # write your code here
        if root is None:
            return node

        elif root.val < node.val:
            root.right = self.insertNode(root.right, node)
        else:
            root.left = self.insertNode(root.left, node)

        return root
