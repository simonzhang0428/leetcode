/*
            i   j   j   j
index   0   1   2   3   4
nums    2   3   1   1   4
dp      2   1   2   1   0

nums    2   1
dp      1   0
currMin 1
*/
class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int curMin = dp[i + 1];
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j > n - 1) {
                    break;
                }
                curMin = Math.min(dp[i + j], curMin);
            }
            dp[i] = curMin + 1;
        }

        return dp[0];
    }
}

public class JumpGame45 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println("2:  " + new Solution45().jump(nums));

    }
}