package OA_amazon;

import java.util.Arrays;

public class MinTruckSize {
    public static void main(String[] args) {
        int[] boxes = {10, 2, 20, 5, 15, 10, 1};
        System.out.println("31:  " + minTruck(boxes, 3));
    }

    public static int minTruck(int[] boxes, int d) {
        int n = boxes.length;
        if (d > n) {
            return -1;
        }

        int[][] dp = new int[n + 1][d + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= d; k++) {
                int maxBox = 0;
                for (int j = i - 1; j >= k - 1; j--) {
                    maxBox = Math.max(maxBox, boxes[j]);
                    dp[i][k] = Math.min(dp[i][k], dp[j][k - 1] + maxBox);
                }
            }
        }

        return dp[n][d];
    }
}
