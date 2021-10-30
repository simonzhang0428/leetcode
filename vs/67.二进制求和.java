/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int left = a.length() - 1, right = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int longer = Math.max(a.length(), b.length());
        
        for (int i = 0; i < longer; i++, left--, right--) {
            int aInt = left >= 0 ? a.charAt(left) - '0' : 0;
            int bInt = right >= 0 ? b.charAt(right) - '0' : 0;

            if (aInt + bInt + carry == 0) {
                sb.append('0');
                carry = 0;
            } else if (aInt + bInt + carry == 1) {
                sb.append('1');
                carry = 0;
            } else if (aInt + bInt + carry == 2) {
                sb.append('0');
                carry = 1;
            } else if (aInt + bInt + carry == 3) {
                sb.append('1');
                carry = 1;
            }
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

