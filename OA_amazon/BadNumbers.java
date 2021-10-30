package OA_amazon;

import java.util.*;

public class BadNumbers {

    public static void main(String[] args) {
        int[] badNumbers = { 37, 7, 22, 15, 49, 60 };
        int lower = 3, upper = 48;
        int res = goodSegment(badNumbers, lower, upper);
        System.out.println("14: " + res);
    }

    static int goodSegment(int badNumbers[], int l, int r) {
        // Sort the numbers
        Arrays.sort(badNumbers);
        int length = 0;
        for (int i = 0; i < badNumbers.length; i++) {
            // loop untill we get to a number greater than or equal to l
            if (badNumbers[i] < l)
                continue;
            // stop when you see a number that is greater than or equal to r
            if (badNumbers[i] > r)
                break;
                
            // find the length of the segment with l and badNumbers[i]
            // then find the maximum of the previous length and current length
            length = Math.max(length, badNumbers[i] - l);
            // update the value of l
            l = badNumbers[i] + 1;
        }
        // return the length at the end
        return length;
    }
}
