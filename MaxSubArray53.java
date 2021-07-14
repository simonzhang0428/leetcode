/*
index   0   1   2   3   4   5   6   
nums    1   2   4   -1  -2  10  -1
dp      1   3   7   6   4   14  13
global_max = 14

index   0   1   2   3   4   5   6   
nums    1   2   4   -1  -20 10  -1
dp      1   3   7   6   -14 10  9
global_max = 10

index   0   1   2   3   4   5   6   
nums    1   2   4   -1  -20 10  -1
prev                        10
curr                            9
global_max = 10
*/
class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            globalMax = Math.max(globalMax, dp[i]);
        }

        return globalMax;
    }


    // reduce space complexity, only use prev and curr
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prev = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            if (prev >= 0) {
                curr += prev;
            } 
            globalMax = Math.max(globalMax, curr);
            prev = curr;
        }

        return globalMax;
    }
}

public class MaxSubArray53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("6:  " + new Solution53().maxSubArray(nums));
        System.out.println("6:  " + new Solution53().maxSubArray2(nums));
    }
}