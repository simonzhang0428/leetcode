# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
'''
18:38 - 19:04 - 19:29
15min   20min   5min test/follow up

input: list preorder
output: root node reference
BST, no dup

mapping 
preorder: root - left - right
inorder: sorted(preorder): left - root - right -> beckbottle is sorting O(nlogn)


high level: recursion to build the BST to get left/right subtree:
root: preorder[pre_start] -> find the root in inorder -> left is left subtree, right is right subtree
root.left:  
root.right:

base case: if pre_start > pre_end, return None 
        -> in_start - in_end is the same size

build(  pre, pre_start, pre_end 
        in, in_start, in_end, dict)

dict is hash table for quick lookup position in inorder list -> O(1)
dict : {node.val:idx (in the inorder)} key = 8, value = 3

time: O(n)
space: O(height) + O(n)(building dict) = O(n)

idx     0   1   2   3   4   5
        r   ---left--   -right-
pre:    8   5   1   7   10  12
in:     1   5   7   8   10  12
        ---left--   r   -right-
left_size = 3

1. dict mapping 要熟练
2. test time shorter
3. base case !!!
4. time / space: additional data structure
5. 面试官可能卡表走人，时间到了，自己要控制时间
6. 为代码 -> 翻译
'''
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        inorder = sorted(preorder)
        n = len(preorder)
        d = {}
        for idx, value in enumerate(inorder):
            d[value] = idx
        
        return self.build(preorder, 0, n - 1, inorder, 0, n - 1, d)

    #                           0             5             0            5      
    def build(self, preorder, pre_start, pre_end, inorder, in_start, in_end, d):
        if pre_start > pre_end:
            return None

        root_val = preorder[pre_start]  # 8
        root_node = TreeNode(root_val)  # root(8)
        root_pos = d[root_val]  # 3
        left_size = root_pos - in_start # 3 
        #                                   0 + 1 = 1       0 + 3 = 3                       0       3 - 1 = 2    
        root_node.left = self.build(preorder, pre_start + 1, pre_start + left_size, inorder, in_start, root_pos - 1, d)
        #                                       0 + 3 + 1 = 4           5                 3 + 1 = 4     5
        root_node.right = self.build(preorder, pre_start + left_size + 1, pre_end, inorder, root_pos + 1, in_end, d)

        return root_node
