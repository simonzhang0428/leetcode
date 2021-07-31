# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""
5:35 - 6:03

assumption: value are unique, key may not in the BST
input:  root(TreeNode ref), key(int)
output: root(TreeNode)

high-level: 
1. try to allocate the node with the value of input key
if we not found, we return root
if we found the key node:
    1. node has two children:
        a. find the smallest node in the right subtree
        b. relace the root value with this smallest ndoe val
        c. call the deleteNode funtion to remove the smallest node
    2. node has one child:
        a. has left child, return left
        b. has right child, return right
    3. node has no child:
        return None

time: O(height)
space: O(height) -> call stack: recursive call

test:
                  5            key = 3
            /        \
          3.1(root)      6
        /   \               \
        2     4(r)             7
            /     
           3.5
           /
         3.1 (None)
           
smallset = 3.1
"""
class Solution:
                        # 3.1           3.1 -> None -> 3.5 left
                        # 3.5           3.1 -> 3.5 -> 4 left
                        # 4             3.1
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return None
        
        if root.val > key:
            root.left = self.deleteNode(root.left, key)
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        else:
            if root.left and root.right:
                smallest = self.find_smallest(root.right)
                root.val = smallest.val
                root.right = self.deleteNode(root.right, smallest.val)
            elif root.left:
                return root.left
            elif root.right:
                return root.right
            else:
                return None
        
        return root
    
    def find_smallest(self, root):
        while root.left:
            root = root.left
        return root
            
            
            
            
            