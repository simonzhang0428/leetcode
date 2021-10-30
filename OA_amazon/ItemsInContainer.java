package OA_amazon;

import java.util.*;

public class ItemsInContainer {
    /**
     *  0   1   2   3   4   5   6
     *  |   *   *   |   *   |   *
     *              s               
     * range = [[0, 4], [1, 6], [1, 3]]
     * ans = [2, 1, 0]
     */
    public static List<Integer> countItems(String s, int[][] ranges) {
        List<Integer> res = new ArrayList<>();
        for (int[] range : ranges) {
            int startIndex = range[0];
            int endIndex = range[1];
            int total = 0;

            // skip all leading *, until hit '|'
            while (startIndex < endIndex && s.charAt(startIndex) != '|') {
                startIndex++;
            }
            
            while (startIndex < endIndex) {
                startIndex++; // move to the next beginning of *, or out of range
                int eachBlockCount = 0;
                while (startIndex < endIndex && s.charAt(startIndex) == '*') {
                    eachBlockCount++;
                    startIndex++;
                }
                total += eachBlockCount; // startIndex now at '|'
            } 
            res.add(total);
        }
        
        return res;
    }


    public static void main(String[] args) {
        String s1 = "|**|*|*";
        int[][] ranges = {{0, 4}, {1, 6}, {1, 3}};
        System.out.println("[2, 1, 0]:  " + countItems(s1, ranges));

        String s2 = "*|*|";
        int[][] ranges2 = { { 1, 3 }};
        System.out.println("[1]:  " + countItems(s2, ranges2));
    }
}
