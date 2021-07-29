# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""
stk = []
res = [3, 7, 9, 15, 20]
"""
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self._push_left_most(root)  

    def next(self) -> int:
        if self.hasNext():
            item = self.stack.pop()
            if item.right:
                self._push_left_most(item.right)
            return item.val
        

    def hasNext(self) -> bool:
        return len(self.stack) > 0
        
    def _push_left_most(self, node):
        while node:
            self.stack.append(node)
            node = node.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()