package OA_Citadel;

import java.util.Arrays;
import java.util.List;

public class PortfolioBalance {
    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 2, 10), Arrays.asList(2, 4, 5), Arrays.asList(3, 5, 12));
        System.out.println("17: " + test(input, 3));
    }

    public static int test(List<List<Integer>> input, int n) {
        int[] ans = new int[n];
        for (List<Integer> i : input) {
            ans[i.get(0) - 1] += i.get(2);
            if (i.get(1) < n) {
                ans[i.get(1)] -= i.get(2);
            }
        }

        int max = ans[0];
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
            max = Math.max(max, ans[i]);
        }

        return max;
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2]; // [i - j] add
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2]; // [j+1, last] sub
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }

}
