"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

        5       target = 7.1
       / \
     4    9     
    /    / \
   2    8  10
upper = 8
lower = 5
diff = 
"""

class Solution:
    """
    @param root: the given BST
    @param target: the given target
    @return: the value in the BST that is closest to the target
    """
    def closestValue(self, root, target):
        # write your code here
        upper = root
        lower = root

        while root:
            if root.val < target:
                lower = root
                root = root.right
            elif root.val > target:
                upper = root
                root = root.left
            else:
                return root.val
        
        return upper.val if math.fabs(upper.val - target) < math.fabs(lower.val - target) else lower.val


