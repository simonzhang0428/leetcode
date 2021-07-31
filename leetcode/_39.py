"""
10:45   7/30

2， 3， 5   target = 8
lvl                                        []8     [cur]rem
                0/              1/        2\              3\          4\
0: 2            []8             [2]6        [2,2]4      [2,2,2]2        [2,2,2,2]0  
            0/      1\    2\
1: 3       []8     [3]5     [3,3]2 
         0/   1\    
2: 5    []8     [5]3
         |        |
3:      ret       ret

base case: 1. remain == 0, copy sol to res
            2.  lvl == len(nums) and remain != 0, return(wrong ans)
recursive rule: for every possible count of nums[idx], DFS until hit the base case

time: O(T/min(nums) ^ len(nums))
space: O(len(nums))
"""
class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res, cur = [], []
        self.dfs(nums, target, 0, cur, res)
        return res
    
    def dfs(self, nums, remain, idx, cur, res):
        if remain == 0:
            res.append(cur[:])
            return
        if idx == len(nums):
            return
        
        times = remain // nums[idx]
        for i in range(times + 1):
            if i > 0:
                cur.append(nums[idx])
            self.dfs(nums, remain - i * nums[idx], idx + 1, cur, res)
        for _ in range(times):
            cur.pop()