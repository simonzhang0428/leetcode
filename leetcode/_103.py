# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        res, dp, lvl = [], deque([root]), 0
        while dp:
            sz = len(dp)
            cur = []
            for _ in range(sz):
                if lvl % 2 == 0:
                    node = dp.popleft()
                    cur.append(node.val)
                    if node.left:
                        dp.append(node.left)
                    if node.right:
                        dp.append(node.right)
                else:
                    node = dp.pop()
                    cur.append(node.val)
                    if node.right:
                        dp.appendleft(node.right)
                    if node.left:
                        dp.appendleft(node.left)
            res.append(cur)
            lvl += 1
        return res
        