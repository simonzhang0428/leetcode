"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

14:58 - 15:17
same time: landing first
high level:
    form new list with tuple(start, 1), (end, -1)
    sort list
    for loop list:
        find start, tmp++
        find end, tmp--
        maintain ans
    return ans

input:  [(1, 10), (2, 3), (5, 8), (4, 7)]
time:   [(1, 1), (2, 1), (3, -1), (4, 1), (5, 1), (8, -1), (7, -1), (10, -1)]
tmp: 0
max: 3
"""

class Solution:
    """
    @param airplanes: An interval array
    @return: Count of airplanes are in the sky.
    """
    def countOfAirplanes(self, airplanes):
        # write your code here
        times = []
        for interval in airplanes:
            times.append((interval.start, 1))
            times.append((interval.end, -1))
        times.sort()

        tmp, ans = 0, 0
        for idx, cost in times:
            tmp += cost
            ans = max(ans, tmp)

        return ans
