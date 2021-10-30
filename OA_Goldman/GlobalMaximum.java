package OA_Goldman;

import java.util.*;

public class GlobalMaximum {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);

        System.out.println(input);
        System.out.println("1: " + globalMax(input, 3));
    }

    public static int globalMax(List<Integer> input, int m) {
        List<Integer> subset = getSubset(input, m);
        int max = 0;

        return max;
    }

    public static List<Integer> getSubset(List<Integer> input, int m) {
        List<Integer> subset = new ArrayList<>();
        Collections.sort(input);

        

        return subset;
    }
}
