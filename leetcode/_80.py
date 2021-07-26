'''
idx 0   1   2   3   4   5
elm 1   1   2   2   3   3
                        i
                            j
i: all elements to the left hand side of i (not including) are the result to return
j: current index to scan whole input array
res = 2
'''
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return n
        i, res = 2, 2
        for j in range(2, n):
            if nums[j] != nums[i - 2]:
                nums[i] = nums[j]
                i += 1
        return i