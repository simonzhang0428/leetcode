/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        else {
            String lastStr = countAndSay(n - 1); // 1 2 1 1
            StringBuilder ans = new StringBuilder();
            int i = 0, j = 1, len = lastStr.length();
            while (j < len) {
                if (lastStr.charAt(i) != lastStr.charAt(j)) {
                    ans.append(j - i).append(lastStr.charAt(i));
                    i = j;
                }
                j++;
            }
            ans.append(j - i).append(lastStr.charAt(i));
            return ans.toString();
        }
    }
}

// @lc code=end

