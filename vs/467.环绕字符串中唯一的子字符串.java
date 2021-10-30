/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter
        int[] count = new int[26];
        int n = p.length(), max = 1;
        char[] pc = p.toCharArray();

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                int t = pc[i] - pc[i - 1];
                if (t == 1 || t == -25) {
                    max++;
                } else {
                    max = 1;
                }
            }

            int index = pc[i] - 'a';
            count[index] = Math.max(count[index], max);
        }

        int res = 0;
        for (int c : count) {
            res += c;
        }
        return res;
    }
}
// @lc code=end

