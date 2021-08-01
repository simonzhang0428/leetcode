# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
'''
16:50 - 17:02
BFS

high level:
BFS traversal whole tree, maintain a queue:
update result when the node pop from queue is a leaf node
otherwise, update left / right node.val, add node to queue

time: O(n)
space: O(n)

test:
            4(4)
        /       \
        9(49)       0(40)
    /       \
    5(495)       1(491)
q = [49]
cur = 4
res = 
'''
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        res = 0
        q = collections.deque([root])
        while q:
            cur = q.popleft()
            if not cur.left and not cur.right:
                res += cur.val
            if cur.left:
                cur.left.val = cur.val * 10 + cur.left.val  # modify left node val, and append it to queue
                q.append(cur.left)
            if cur.right:
                cur.right.val = cur.val * 10 + cur.right.val
                q.append(cur.right)
        return res

"""
7/31 16:10 - 16:30

input: root: TreeNode
output: res: int

high level: DFS with recursion
preorder traversal tree, when hit the leaf, add the path to final res

mid level:
base case: None node, return
recursive rule: 
path = 10 * path + current_node.val
hit the leaf node, add path to res

time: O(n) n is number of input tree nodes
space: O(height)

test:
            4(4)
        /       \
        9(49)       0
    /       \
    5(495)       1
    
path = 40
res = 495 + 491 + 40 = 1026

"""
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.res = 0
        self.preorder(root, 0)
        return self.res

    def preorder(self, root, path):
        if not root:
            return

        path = 10 * path + root.val
        if not root.left and not root.right:
            self.res += path

        self.preorder(root.left, path)
        self.preorder(root.right, path)

"""
17:08 - 17:21

DFS with stack
stack = [node]
if node is leaf, add cur_sum to res
if ndoe.left: node.left.val += 10 * cur_sum

test:
          4
        /   \
        49     40
       /   \
    495    491
stack = [495, 491]
cur = 
res = 40 + 495 + 491
"""
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0

        res = 0
        stack = [root]
        while stack:
            cur = stack.pop()
            if not cur.left and not cur.right:
                res += cur.val
            if cur.left:
                cur.left.val += cur.val * 10 
                stack.append(cur.left)
            if cur.right:
                cur.right.val += cur.val * 10
                stack.append(cur.right)
        
        return res