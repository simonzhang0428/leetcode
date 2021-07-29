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
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        
        res = []
        self.dfs(nums, 0, res)
        return res
    
    def dfs(self, nums, index, res):
        if index == len(nums):
            res.append(nums[:])
            return
        
        s = set()
        for i in range(index, len(nums)):
            if nums[i] in s:
                continue
                
            s.add(nums[i]) 
            nums[i], nums[index] = nums[index], nums[i]
            self.dfs(nums, index + 1, res)
            nums[index], nums[i] = nums[i], nums[index]
            