/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();

        // System.out.println(s);

        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            int j = k;
            while (i >= 0 && j-- > 0) {
                sb.append(s.charAt(i--));
            }
            if (i != -1) {
                sb.append("-");
            }
        }
        while (i >= 0) {
            sb.append(s.charAt(i--));
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

