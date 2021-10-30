package OA_Goldman;

import java.util.*;

public class MeanderingArray {

    public static List<Integer> meanderingArray(List<Integer> input) {
        List<Integer> res = new ArrayList<>();
        Collections.sort(input);
        int start = 0, end = input.size() - 1;

        while (start < end) {
            res.add(input.get(end));
            end--;
            res.add(input.get(start));
            start++;
        }
        if (start == end) {
            res.add(input.get(start));
        }

        return res;
    }
    
    public static void main(String[] args) {

        // creating two lists
        List<Integer> OriginalList = new ArrayList<>();

        // adding integers to Original list
        OriginalList.add(-1);
        OriginalList.add(1);
        OriginalList.add(2);
        OriginalList.add(3);
        OriginalList.add(-5);

        System.out.println("Original List of Integers: ");
        System.out.println(OriginalList);

        // Calling function meandering array with original list and holding the returned
        // list in the modified list
        List<Integer> ModifiedList = meanderingArray(OriginalList);

        System.out.println("Modified List of Integers: ");
        System.out.println(ModifiedList);
    }

}

