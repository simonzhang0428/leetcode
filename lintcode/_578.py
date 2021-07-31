"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""


class Solution:
    """
    @param: root: The root of the binary tree.
    @param: A: A TreeNode
    @param: B: A TreeNode
    @return: Return the LCA of the two nodes.
    """
    def lowestCommonAncestor3(self, root, p, q):
        # write your code here
        sol = self.findLCA(root, p, q)
        if not sol:
            return None
        if sol == p:
            if not self.findLCA(p, q, q):
                return None
            return p
        if sol == q:
            if not self.findLCA(q, p, p):
                return None
            return q
        return sol
    
    # assume p, q are in the tree
    def findLCA(self, root, p, q):
        if not root or root == p or root == q:
            return root

        left = self.findLCA(root.left, p, q)
        right = self.findLCA(root.right, p, q)

        if left and right:
            return root
        return left if not right else right