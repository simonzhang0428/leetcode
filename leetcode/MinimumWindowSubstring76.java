package leetcode;
/*
0   1   2   3   4   5   6   7   8   9   10  11  12
A   D   O   B   E   C   O   D   E   B   A   N   C
                                        i
                                                    j
A   B   C   D   o   e   n
1   1   1   10   100   1
need = 0
minLength = 4
startIndex = 9
*/
class Solution76 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] map = new int[128];
        int need = t.length();
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE, startIndex = -1;
        char[] ch = s.toCharArray();
        while (j < ch.length) {
            char c = ch[j];
            if (map[c] > 0) {
                need--;
            }
            map[c]--;
            j++;

            // if need is zero, we move left
            while (need == 0) {
                if (j - i < minLength) {
                    minLength = j - i;
                    startIndex = i;
                }
                c = ch[i];
                map[c]++;
                if (map[c] > 0) {
                    need++;
                }
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println("BANC:   " + new Solution76().minWindow(source, target));
    }
}