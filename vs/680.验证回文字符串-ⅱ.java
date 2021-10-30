/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j && chars[i] == chars[j]) {
            i++;
            j--;
        }
        // 至此有两种情况：
        // ① i>=j s本身就是回文串
        // ② i<j && s[i] != s[j]必须要删一个
        // 要么删s[i]，判断s[i+1,j]是否是回文串
        // 要么删s[j]，判断s[i,j-1]是否是回文串
        return i >= j || isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1);
    }

    private boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j && chars[i] == chars[j]) {
            i++;
            j--;
        }
        return i >= j;
    }
}
// @lc code=end

