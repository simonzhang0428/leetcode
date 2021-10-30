package OA_Citadel;

import java.util.Arrays;
import java.util.List;

public class JungleBook {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(-1, 8, 6, 0, 7, 3, 8, 9, -1, 6);

        int res = test(input);
        System.out.println("5: " + res);
    }

    public static int test(List<Integer> input) {
        int res = 0;
        for (Integer i : input) {
            int count = 1;
            int temp = i;
            while (temp > -1) {
                count++;
                temp = input.get(temp);
            }

            if (count > res) {
                res = count;
            }
        }
        return res;
    }
}
