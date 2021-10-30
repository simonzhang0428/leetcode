/*
 * @lc app=leetcode.cn id=1283 lang=java
 *
 * [1283] 使结果不超过阈值的最小除数
 */

// @lc code=start
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 1_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isValid(nums, mid, threshold)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean isValid(int[] nums, int guess, int threshold) {
        int sum = 0;
        for (int n : nums) {
            sum += (int)Math.ceil(1.0 * n / guess);
        }
        return sum <= threshold;
    }
}
// @lc code=end

