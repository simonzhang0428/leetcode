/*
index   0   1   2   3   4
nums    3   2   1   0   4
max = 3                         
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

    // greedy
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int maxReachable = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] + i >= maxReachable) {
                maxReachable = nums[i] + i;
            }
        }

        return maxReachable >= n - 1;
    }

    // better greedy, corner case
    public boolean canJump3(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int maxReachable = 0;
        for (int i = 0; i < n - 1; i++) {
            maxReachable = Math.max(i + nums[i], maxReachable);
            if (maxReachable >= n - 1) {
                return true;
            }
            // [1, 0, 1, 0] early return
            if (i != n - 1 && maxReachable == i) {
                return false;
            }
        }

        return false;
    }
}

public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("true:  " + new Solution55().canJump(nums));
        System.out.println("false:  " + new Solution55().canJump3(nums2));

    }
}