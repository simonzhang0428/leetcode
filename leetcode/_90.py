'''
8/01    22:35 - 23:30 

input: []
output: [[..],[..]]
assumption: all int, may be duplicate

DFS + de-dup
                     idx    0   1   2
                            1,  2,  2
                    /                   \   
0                1                          []
            /          \                    /   \ 
1           1,2             1               2       []
         /    |           / |         /     |      /  \
2    1,2,2   1,2      1,2   1       2,2     2      2   []
3
test:
nums = [1, 2, 2], len = 3
res = [[1, 2, 2], [1, 2], [1], [2, 2], [2], []]
path = []
idx = 
'''
class Solution:
    def subsets_with_dup(self, nums):
        if not nums or len(nums) == 0:
            return []
        res = []
        self.dfs(sorted(nums), [], 0, res)
        return res

            #    [1,2,2] []   0    []   {}
    def dfs(self, nums, path, idx, res):
        if idx == len(nums):
            res.append(path[:])
            return
        
        path.append(nums[idx])
        self.dfs(nums, path, idx + 1, res)
        path.pop()
        while idx < len(nums) - 1 and nums[idx + 1] == nums[idx]:
            idx += 1

        self.dfs(nums, path, idx + 1, res)

if __name__ == '__main__':
    sol = Solution()
    print(sol.subsets_with_dup([1, 2, 2]))