/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1, right = i + 1;
            String sub = getString(s, left, right);
            if (sub.length() > ans.length()) {
                ans = sub;
            }

            left = i - 1; 
            right = i;
            sub = getString(s, left, right);
            if (sub.length() > ans.length()) {
                ans = sub;
            }
        }
        return ans;
    }

    private String getString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
// @lc code=end

