import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += count(s, i, i);

            ans += count(s, i, i + 1);
        }
        return ans;
    }

    private int count(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
            count++;
        }
        return count;
    }
}
// @lc code=end

