package OA_amazon;
import java.util.*;

public class SubstringOfSizeKWithKDistinctChar {
    public static void main(String[] args) {
        System.out.println("[abc, bca, cab]:  " + getSubstring("abcabc", 3));
    }

    /**
     * 0    1   2   3   4   5   k = 3
     * a    b   c   a   b   c
     *              s   
     *                      e
     * window: [a, b, c]
     * result
     */
    public static List<String> getSubstring(String s, int k) {
        int n = s.length();
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int start = 0, end = 0; end < n; end++) {
            
            char ch = s.charAt(end);
            while (window.contains(ch)) {
                window.remove(s.charAt(start));
                start++;
            }

            window.add(ch);
            
            if (window.size() == k) {
                result.add(s.substring(start, end + 1));
                window.remove(s.charAt(start));
                start++;
            }
        }

        return new ArrayList<String>(result);
    }

}
