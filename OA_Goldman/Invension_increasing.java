package OA_Goldman;

public class Invension_increasing {
    public static void main(String[] args) {
        int[] num_inv = {1, 2, 4, 3, 5};
        int[] nums2_inv = {1, 2, 2, 4};

        System.out.println("7: " + solveMain(num_inv)); 
        System.out.println("2: 有重复" + solveMain(nums2_inv));

    }

    private static int solve(int[] nums, int k) { // 递增
        int[][] dp = new int[k][nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[0][i] = 1;
        for (int l = 1; l < k; l++) {
            for (int i = l; i < nums.length; i++) {
                for (int j = l - 1; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[l][i] += dp[l - 1][j];
                    }
                }
            }
        }
        int res = 0;
        for (int i = k - 1; i < nums.length; i++) {
            res += dp[k - 1][i];
        }
        return res;
    }

    // 递增tuple size of 3
    public static int solveMain(int[] arr) {
        return solveMain(arr, 3);
    }

    public static int solveMain(int[] arr, int k) {
        int sol = 0;
        Integer[][] dp = new Integer[arr.length][k + 1];
        for (int i = 0; i < arr.length; ++i)
            sol += solve(arr, i, k - 1, dp);
        return sol;
    }

    public static int solve(int[] arr, int index, int nums, Integer[][] dp) {
        if (nums == 0)
            return 1;
        if (index >= arr.length)
            return 0;
        if (dp[index][nums] != null)
            return dp[index][nums];
            
        // use arr[index]
        int sol = 0;
        for (int i = index + 1; i < arr.length; ++i) {
            if (arr[i] > arr[index])
                sol += solve(arr, i, nums - 1, dp);
        }
        dp[index][nums] = sol;
        return sol;
    }
}

