"""
idx 0   1   2   3          val = 3 -> ret 2, [2, 2]
elm 2   2   2   3   
                    i
            idx
i: all elements to the left hand side of i (including) are the result to return
j: current index to scan whole input array
res = 0
"""
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        idx = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[idx] = nums[i]
                idx += 1
        return idx

