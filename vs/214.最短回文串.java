/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    /**
     * Consider a decimal example. Say we are given a number 7134. 
     * If we read it from left to right, we get 7134. 
     * And 4317 if we read it from right to left.
     * 
     * hash1 is the left--to-right fashion:
     * 
     * hash1 = 0 
     * hash1 = 0 * 10 + 7 = 7 
     * hash1 = 7 * 10 + 1 = 71 
     * hash1 = 71 * 10 + 3 = 713 
     * hash1 = 713 * 10 + 4 = 7134 
     * 
     * hash2 is the right-to-left fashion:
     * 
     * hash2 = 0 
     * hash2 = 0 + 7 * 1 = 7 
     * hash2 = 7 + 1 * 10 = 17 
     * hash2 = 17 + 3 * 100 = 317 
     * hash2 = 317 + 4 * 1000 = 4317
     */
    public String shortestPalindrome(String s) {
        int n = s.length(), pos = -1;
        long B = 29, MOD = 1000000007, POW = 1, hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++, POW = POW * B % MOD) {
            hash1 = (hash1 * B + s.charAt(i) - 'a') % MOD;
            hash2 = (hash2 + (s.charAt(i) - 'a') * POW) % MOD;
            if (hash1 == hash2)
                pos = i;
        }
        return new StringBuilder().append(s.substring(pos + 1, n)).reverse().append(s).toString();
    }
}

// @lc code=end

