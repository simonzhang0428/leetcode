/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int one = 1, two = 2;
        for (int i = 0; i < n - 1; i++) {
            int temp = two;
            two = one + two;
            one = temp;
        }

        return one;
    }
}
// @lc code=end

