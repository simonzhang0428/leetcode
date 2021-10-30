/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') y--;
            else if (c == 'D') y++;
            else if (c == 'L') x--;
            else if (c == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
// @lc code=end

