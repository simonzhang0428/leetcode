import java.util.*;
/*
ex  0   1   2   3
    a   b   a   b   
                L
                    R
map:    pattern = ab
a : 1
b : 0

typesToMatch = 1
ans = [0, 1, 2]
====================

ex  0   1   2   3   4   5   6   7   8   9   pattern = abc
    c   b   a   e   b   a   b   a   c   d
        ---------
        L
                R
map:
a : 0
b : 0
c : 0

typesToMatch = 0
ans = [0]

*/
class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCnt, pCnt)){
            res.add(0);
        }
        for(int i = m; i < n; i++){
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)){
                res.add(i - m + 1);
            }
        }
        return res;
    }
}

public class FindAnagrams438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", pattern = "abc";
        List<Integer> ret = new Solution438().findAnagrams(s, pattern);
        System.out.println(ret);
    }
}
