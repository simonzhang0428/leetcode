import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int need = t.length();

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = -1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0) { // 先看在减
                need--;
            }
            map[c]--;
            right++;

            while (need == 0) { // 用while
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++; // 先加在看
                if (map[leftChar] > 0) {
                    need++;
                }
                left++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
// @lc code=end

