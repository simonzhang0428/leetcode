/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * r;
            r *= nums[i];
        }
        return res;
    }
    // O(N), O(1)
}
// @lc code=end

