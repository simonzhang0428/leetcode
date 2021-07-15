class Solution509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
public class Fibonacci509 {
    public static void main(String[] args) {
        System.out.println("5:  " + new Solution509().fib(5));
        int res = new Solution509().fib(5);
        assert (res != 5) : "Something wrong";
    }
}
