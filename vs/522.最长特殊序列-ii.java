/*
 * @lc app=leetcode.cn id=522 lang=java
 *
 * [522] 最长特殊序列 II
 */

// @lc code=start
class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequency(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                return strs[i].length();
            }
        } 

        return -1;
    }

    private boolean isSubsequency(String s, String t) {
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }
    // time: O(N^2 x K)
    // space: O(1)
}
// @lc code=end

