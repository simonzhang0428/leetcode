package OA_Citadel;

public class WaysToSum {
    public static void main(String[] args) {
        int total = 8;
        int k = 2;
        System.out.println("5: " + test(total, k));
        System.out.println("5: " + test(5, 3));
    }

    public static int test(int total, int k) {
        int MOD = 1_000_000_000 + 7;
        int[][] dp = new int[k + 1][total + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= total; j++) {
                if (i == j) {
                    dp[i][j] = (dp[i - 1][j] + 1) % MOD;
                } else if (i > j) {
                    dp[i][j] = (dp[i - 1][j]) % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - i]) % MOD;
                }
            }
        }

        return dp[k][total];
    }
    
}
