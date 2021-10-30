/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        } else {
            double half = myPow(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                if (n > 0) {
                    return half * half * x;
                } else {
                    return half * half / x;
                }
            }
        }
    }
    // time: O(logN)
}
// @lc code=end

