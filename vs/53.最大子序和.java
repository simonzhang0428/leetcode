/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    /** 0  1   2                 n-1
     * -2, 1, -3, 4,-1, 2, 1, -5, 4
     * 0, -2, 1, -2, 2, 1, 3, 4, -1, 3 
     */

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum = nums[0];
        int max = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }

    public int maxSubArray4(int[] nums) {
        int[] dp = new int[nums.length]; // including i, max sub array
        dp[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    } // no need to keep dp array

    public static int maxSubArray(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}
// @lc code=end

