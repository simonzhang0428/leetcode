"""
Definition of ParentTreeNode:
class ParentTreeNode:
    def __init__(self, val):
        self.val = val
        self.parent, self.left, self.right = None, None, None
"""


class Solution:
    """
    @param: root: The root of the tree
    @param: A: node in the tree
    @param: B: node in the tree
    @return: The lowest common ancestor of A and B

    sa = {4}
    b = {7, 4}
    """
    def lowestCommonAncestorII(self, root, A, B):
        # write your code here
        if not root or root == A or root == B:
            return root
        sa = set()
        sa.add(A)
        while A:
            sa.add(A.parent)
            A = A.parent
        while B:
            if B in sa:
                return B
            B = B.parent 

    def lowestCommonAncestorII_height(self, root, A, B):
        # write your code here
        ha = self.height(A)
        hb = self.height(B)
        while ha > hb:
            A = A.parent
            ha -= 1
        while hb > ha:
            B = B.parent
            hb -= 1
        while A != B:
            A = A.parent
            B = B.parent
        return A

    def height(self, node):
        h = 0
        while node:
            h += 1
            node = node.parent
        return h
            
