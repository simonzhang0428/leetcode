package OA_Citadel;

import java.util.*;
import java.util.Collections;

public class Triplets {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        Collections.addAll(input, 1, 2, 3, 4, 5);
        System.out.println("4: " + test(input, 8));
    }

    public static int test(List<Integer> input, int target) {
        Collections.sort(input);
        int n = input.size(), res = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = input.get(i) + input.get(j) + input.get(k);
                if (sum <= target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
    // time: O(n^2)
}
