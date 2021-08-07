"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

15:24 - 15:29
input: [(0,30),(5,10),(15,20)]
output: 2

high - level:
    to find the max overlap rooms
    times = []
    for i in intervals:
        times.append((i.start, 1))
        times.append((i.end, -1))
    times.sort()
    tmp, ans = 0, 0
    for idx, cost in times:
        tmp += cost
        ans = max(tmp, ans)
    return ans

time: O(NlogN)
space: O(N)
"""

class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def minMeetingRooms(self, intervals):
        # Write your code here
        times = []
        for i in intervals:
            times.append((i.start, 1))
            times.append((i.end, -1))
        times.sort()

        tmp, ans = 0, 0
        for idx, cost in times:
            tmp += cost
            ans = max(tmp, ans)
        return ans
