/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] spots = new boolean[24 * 60];
        for (String time : timePoints) {
            char[] timeChars = time.toCharArray();
            int hour = (timeChars[0] - '0') * 10 + (timeChars[1] - '0');
            int minute = (timeChars[3] - '0') * 10 + (timeChars[4] - '0');
            int total = hour * 60 + minute;

            if (spots[total]) {
                return 0;
            }

            spots[total] = true;
        }

        int res = 24 * 60, prev = - 24 * 60;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (spots[i]) {
                res = Math.min(res, i - prev);
                min = Math.min(min, i);
                max = Math.max(max, i);
                prev = i;
            }
        }
        res = Math.min(24 * 60 + min - max, res);
        return res;
    }
}
// @lc code=end

