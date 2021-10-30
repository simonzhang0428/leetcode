package OA_amazon;

import java.util.*;

public class Frequency {

    public static void main(String[] args) {
        
        // frequency
        String s = "1(2)23(3)"; // aabccc
        // int[] res = frequency(s);
        // System.out.println(res[0] + "   a: 2");
        // System.out.println(res[1] + "   b: 1");
        // System.out.println(res[2] + "   c: 3");

        String s2 = "23#(2)24#25#26#23#(3)"; // wwxyzwww
        // int[] res2 = frequency(s2);
        // System.out.println(res2[22] + "   w: 5");
        // System.out.println(res2[23] + "   x: 1");
        // System.out.println(res2[24] + "   y: 1");
        // System.out.println(res2[25] + "   z: 1");

        System.out.println(frequency(s2));
    }

    /**
     * 
     * only lowercase, 26, a-z
     * a = 1, b = 2, c = 3... i = 9
     * j = 10#, k = 11#... z = 26#
     * 
     * 连续出现，加（次数）
     * abzx:    1 2 26# 24# 反向找，遇到#看前面两位，没有#就单个看
     * aabccc:  1 (2) 2 3(3) 括号优先级高，括号一定在#后面出现，先找到括号，拿到3, 出现（次数清零
     * bajj:    2 1 10# (2) 找到），拿到2，找到#看两位，
     * wwxyzwww: 23#(2)24#25#26#23#(3)
     * 
     * Given String s, determine the character counts for each letter
     * decode string, return an integer array of length 26 
     * where index 0 contains the number of 'a', index 1 is number of 'b'...
     */
    public static List<Integer> frequency(String s) {
        int[] res = new int[26]; // 0 - 25
        int num = 0, n = s.length(), target = -1;

        int i = n - 1;
        while (i >= 0) {

            // get the ? from (?) 
            if (s.charAt(i) == ')') {
                i --;
                while (s.charAt(i) != '(') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i --;
                }
                i --; // skip (
            }

            // get xx from xx#
            if (s.charAt(i) == '#') {
                char tenDigit = s.charAt(i - 2);
                char singleDigit = s.charAt(i - 1);
                String twoDigits = String.valueOf(tenDigit) + String.valueOf(singleDigit);
                target = Integer.parseInt(twoDigits);
                i -= 3;
            } else {
                target = s.charAt(i) - '0';
                i --;
            }

            if (num == 0) {
                res[target - 1]++;
            } else {
                res[target - 1] += num;
                num = 0;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            list.add(res[j]);
        }
        return list;
    }
}
