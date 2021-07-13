/*
index   0   1   2   3   4
nums    2   3   1   1   4
dp                      T
*/
// Time = O(n * k), where k is min(n, largest value in nums array)
class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i]; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}

public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("true:  " + new Solution55().canJump(nums));
        System.out.println("false:  " + new Solution55().canJump(nums2));

    }
}