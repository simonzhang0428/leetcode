/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int left = num1.length() - 1, right = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (left >= 0 || right >= 0) {
            int leftNum = left >= 0 ? num1.charAt(left) - '0' : 0;
            int rightNum = right >= 0 ? num2.charAt(right) - '0' : 0;
            int currSum = leftNum + rightNum + carry;

            int value = currSum % 10;
            carry = currSum / 10;
            sb.append(value);

            left--;
            right--;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

