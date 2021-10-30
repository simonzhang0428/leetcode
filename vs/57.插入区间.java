import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // lets make a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (final int[] interval : intervals) {
            // remove the meeting from the heap(Peek) if start of incoming meeting is
            // greater than peek of heap (means with min end time)
            if (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        // at last heap size will me the room require.
        return pq.size();
    }
}
// @lc code=end

