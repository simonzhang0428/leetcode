import heapq
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        res = []
        dict = {}
        for num in nums:
            if num not in dict:
                dict[num] = 1
            else:
                dict[num] += 1
                
        for key, val in dict.items():
            if len(res) < k:
                heapq.heappush(res, [val,key])
            else:
                heapq.heappushpop(res, [val,key])
        return [y for x, y in res]