"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
14:31 -

input:  [(0,30),(5,10),(15,20)]
output: True / False    if can attend all meetings
time    0   5   10  15  20  25  30
        --------------------------
            -----
                    ------
not allow sorting
high level:
    loop the interval, if find latest end time > any start time, return False
    latest end time = -1, update if necessary

test:   [(5,8),(9,15)]
    0   5   10  15
        ---
            ------
latest = 30

"""

class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: if a person could attend all meetings
    """
    def canAttendMeetings(self, intervals):
        # Write your code here
        intervals.sort(key=lambda x: x.start)
        for i in range(len(intervals) - 1):
            if intervals[i].end > intervals[i+1].start:
                return False
        return True