import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<int[]>();
        list.add(intervals[0]);
        int[] curr = intervals[0];
        
        for (int[] next : intervals) {
            
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                curr = next;
                list.add(curr);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end

