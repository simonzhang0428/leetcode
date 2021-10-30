import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        // count adjacnt pair of consecutive zero/one, choose the min
        /**                  i
         * 0 0 1 1 1 1 0 1 0 
         * prev = 1
         * cur = 1
         * ans = 2 + 1 + 1 + 1
         */
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
    // O(N), O(1)
}
// @lc code=end

