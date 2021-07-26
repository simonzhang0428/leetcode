"""
idx 0   1   2   3   4
elm 1   2   3   2   3
                i
                        j
i: all elements to the left hand side of i (not including) are the result to return
j: current index to scan whole input array
res = 1
"""

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return n
        i, res = 1, 1
        for j in range(1, n):
            if nums[j] != nums[i - 1]:
                nums[i] = nums[j]
                i += 1
        return i