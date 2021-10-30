/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        boolean isPositve = true;
        StringBuilder sb = new StringBuilder();
        int i = 0, n = chars.length;

        while (i < n && chars[i] == ' ') {
            i++;
        }
        if (i < n && chars[i] == '-' || chars[i] == '+') {
            isPositve = chars[i] == '-' ? false : true;
            i++;
        }
        while (i < n && chars[i] >= '0' && chars[i] <= '9') {
            sb.append(chars[i]);
            i++;
        }

        if (sb.length() == 0) {
            return 0;
        }

        long parsed = Long.parseLong(sb.toString());
        if (!isPositve) {
            parsed = -parsed;
        }
        if (parsed < Integer.MIN_VALUE) {
            parsed = Integer.MIN_VALUE;
        } else if (parsed > Integer.MAX_VALUE) {
            parsed = Integer.MAX_VALUE;
        }

        return (int)parsed;
    }
}
// @lc code=end

