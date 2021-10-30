package OA_Citadel;

import java.util.*;

public class FindBeforeMatrix {
    public static void main(String[] args) {

        List<List<Integer>> after = Arrays.asList(Arrays.asList(2, 5), Arrays.asList(7, 17));

        List<List<Integer>> res = test(after);
        // System.out.println(input);
        System.out.println("res = [[2, 3], [5, 7]]: " + res);
    }

    public static List<List<Integer>> test(List<List<Integer>> after) {
        int s = 0;
        List<List<Integer>> before = new ArrayList<List<Integer>>();

        for (int i = 0; i <= after.size() - 1; i++) {

            List<Integer> bRow = new ArrayList<Integer>();

            for (int j = 0; j <= after.get(i).size() - 1; j++) {
                if (i < 1 && j < 1) {
                    bRow.add(j, after.get(i).get(j));
                    s = s + after.get(i).get(j);
                } else if (i > 0 && j > 0) {
                    bRow.add(j, after.get(i).get(j) - s);
                } else {
                    bRow.add(j, after.get(i).get(j) - after.get(0).get(0));
                    s = s + after.get(i).get(j) - after.get(0).get(0);
                }
            }

            before.add(i, bRow);
        }
        return before;
    }

}
