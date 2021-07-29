"""
0                    1, 2, 3
                /       \       \
1             1|23      2|13    3|21 
            /       \
2          12|3    13|2
            |       |
3           ret
"""
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.dfs(nums, 0, res)
        return res
    
    def dfs(self, nums, index, res):
        if index == len(nums):
            res.append(nums[:])
            return
        
        for i in range(index, len(nums)):
            nums[index], nums[i] = nums[i], nums[index]
            self.dfs(nums, index + 1, res)
            nums[i], nums[index] = nums[index], nums[i]
