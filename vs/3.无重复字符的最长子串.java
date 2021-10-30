import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, ans = 0;;
        var set = new HashSet<Character>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (!set.add(c)) {
                set.remove(s.charAt(left++));
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }
}
/**
 * pwwkew
 *      
 */
/**
 * two pointer + hash map
 * [start, end], right = charAt(end), left = charAt(start)
 * while (map.get(right) > 1): move left
 * ans = max(ans, end - start + 1)
 * O(N) + O(N)
 */
// @lc code=end

