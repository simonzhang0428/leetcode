"""
idx 0   1   2   3   4   5   6   7          n = 8
elm 1   1   2   3   0   0   0   0   
                                i
    
res 1   0   0   2   3   0   0   4   5   0   0     fake_len = n + zeros
                                            j
"""
class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        n = len(arr)
        zeros = arr.count(0)
        fake_len = n + zeros
        j = fake_len - 1
        for i in range(n-1, -1, -1):
            if arr[i] == 0:
                if j < n:
                    arr[j] = 0
                j -= 1
                if j < n:
                    arr[j] = 0
                j -= 1
            else:
                if j < n:
                    arr[j] = arr[i]
                j -= 1