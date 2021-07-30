
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        lookup = {}
        return self.dfs(node, lookup)

    def dfs(self, node, lookup):
        if not node:
            return None
        if node in lookup:
            return lookup[node]

        new_node = Node(node.val)
        lookup[node] = new_node
        for n in node.neighbors:
            new_node.neighbors.append(self.dfs(n, lookup))

        return new_node