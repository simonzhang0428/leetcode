/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int absentTimes = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentTimes++;
                if (absentTimes == 2) {
                    return false;
                }
            }

            if (i >= 2 && c == 'L' && s.charAt(i - 2) == 'L' && s.charAt(i - 1) == 'L') {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

