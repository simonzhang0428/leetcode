'''
n = 5
pre = [[0, 1], [1, 2], [3, 2], [4, 3], [2, 4]]
0 <-  1 <-  2  -> 3  -> 4
            ^           |
            | - - - - - ]
0: []
1: [0]
2: [1, 3]
3: [4]
4: [2]

-1: current visiting
1: already visited
0: not visited yet
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites or numCourses == 0 or len(prerequisites) == 0:
            return True

        d = {}
        for i in range(numCourses):
            d[i] = []
        for pre in prerequisites:
            after, before = pre[0], pre[1]
            d[before].append(after)
        
        visited = [0 for _ in range(numCourses)]
        for i in range(numCourses):
            if not self.dfs(d, visited, i):
                return False

        return True

    # return False if have a cycle, can't finish
    def dfs(self, d, visited, i):
        if visited[i] == -1:
            return False
        if visited[i] == 1: # previous checked, no cycle, no need to go further
            return True

        visited[i] = -1
        if i in d:
            if d[i]:
                for j in d[i]:
                    if not self.dfs(d, visited, j):
                        return False

        visited[i] = 1
        return True