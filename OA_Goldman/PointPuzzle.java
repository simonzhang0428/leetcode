package OA_Goldman;

import java.util.ArrayList;
import java.util.List;

public class PointPuzzle {
    public static long maxPoints(List<Integer> elements) {
        int[] counters = new int[10001];
        for (int i = 0; i < elements.size(); i++) {
            counters[elements.get(i)]++;
        }

        int[] dp = new int[10001];
        dp[1] = counters[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * counters[i]);
        }

        return dp[10000];
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(6);
        elements.add(6);
        elements.add(4);
        elements.add(11);

        System.out.println(elements);
        System.out.println("27: " + maxPoints(elements));

        elements.clear();
        elements.add(3);
        elements.add(4);
        elements.add(2);

        System.out.println(elements);
        System.out.println("6: " + maxPoints(elements));

        elements.clear();
        elements.add(1);
        elements.add(2);
        elements.add(1);
        elements.add(3);
        elements.add(2);
        elements.add(3);

        System.out.println(elements);
        System.out.println("8: " + maxPoints(elements));
    }
}
