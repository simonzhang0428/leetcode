package OA_Citadel;

import java.util.*;

public class StringChain {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("a", "and", "an", "bear");

        int res = longestChain(input);

        System.out.println("3: " + res);
    }

    public static int longestChain(List<String> input) {
        Collections.sort(input, (w1, w2) -> w1.length() - w2.length());
        Map<String, Integer> wordToLongest = new HashMap<>();
        int res = 0;

        for (String word : input) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, wordToLongest.getOrDefault(sub, 0) + 1);
            }
            wordToLongest.put(word, best);
            res = Math.max(res, best);
        }

        return res;
    }
}
