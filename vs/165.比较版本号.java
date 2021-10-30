/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.+");
        String[] str2 = version2.split("\\.+");

        int n1 = str1.length, n2 = str2.length;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            int i1 = i < n1 ? Integer.parseInt(str1[i]) : 0;
            int i2 = i < n2 ? Integer.parseInt(str2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }

        return 0;
    }
}
// @lc code=end
