"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: a TreeNode
    @return: return a list of integer
    """

    def boundaryOfBinaryTree(self, root):
        self.ans = []
        if(root == None):
            return self.ans
        self.ans.append(root.val)
        self.dfs(root.left, True, False) # isLeftMost = T, isRightMost = F
        self.dfs(root.right, False, True)
        return self.ans

    def dfs(self, root, lft, rgt):
        if(root == None):
            return
        if(root.left == None and root.right == None):
            self.ans.append(root.val)
            return
        if(lft):
            self.ans.append(root.val)
        self.dfs(root.left, lft, rgt and root.right == None)
        self.dfs(root.right, lft and root.left == None, rgt)
        if(rgt):
            self.ans.append(root.val)
        
