import java.util.*;

class Solution3 {
    /*
    0   1   2   3   4   5   
    p   w   w   k   e   w
        s
            f
    freq:
    p   0
    w   2   
    */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int slow = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.get(c) > 1) {
                char sc = s.charAt(slow);
                freq.put(sc, freq.get(sc) - 1);
                slow++;
            } 
            ans = Math.max(ans, fast - slow + 1);
        }
        return ans;
    }
}

public class LengthOfLongestSubstring3 {
    public static void main(String[] args) {
        System.out.println("3:  " + new Solution3().lengthOfLongestSubstring("pwwkew"));
    }
}
