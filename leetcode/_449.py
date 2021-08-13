# Definition for a binary tree node.
import bisect, collections

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
'''
10:12 - 
High level idea: preorder traversal + DFS
          2
        /   \
        1    3
       /      \
      0        4
preorder = [2, 1, 0, 3, 4]

'''
class Codec:

    def serialize(self, root: TreeNode) -> str:     # ['2', '1'] 
        """Encodes a tree to a single string.
        """
        preorder = []
        if not root:
            return ''
        preorder.append(str(root.val))
        if root.left:
            preorder.append(self.serialize(root.left))
        if root.right:
            preorder.append(self.serialize(root.right)) 
    
        return ','.join(preorder)

    def deserialize(self, data: str) -> TreeNode:
        """Decodes your encoded data to tree.
        """
        if len(data) == 0:
            return None

        preorder = data.split(',')
        return self.deserialize_helper(preorder)
        
    def deserialize_helper(self, preorder: list) -> TreeNode:
        if not 
        val = preorder[0]
        root = TreeNode(val)
        i = bisect.bisect(preorder, val)

        root.left = self.deserialize_helper(preorder[1:i])
        root.right = self.deserialize_helper(preorder[i:])
        return root
        
class Codec:

    def serialize(self, root: TreeNode) -> str:
            """Encodes a tree to a single string. """
            ret = []
            def preorder(root):
                if root:
                    ret.append(root.val)
                    preorder(root.left)
                    preorder(root.right)
            preorder(root)
            return ' '.join(map(str, ret))

    def deserialize(self, data: str) -> TreeNode:
        """Decodes your encoded data to tree. """
        nums = collections.deque(int(n) for n in data.split())
        def build(mmin, mmax):
            if nums and mmin < nums[0] < mmax:
                n = nums.popleft()
                node = TreeNode(n)
                node.left = build(mmin, n)
                node.right = build(n, mmax)
                return node
            
        return build(float('-inf'), float('inf'))

# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
ser = Codec()
deser = Codec()
tree = ser.serialize(root)
ans = deser.deserialize(tree)
return ans