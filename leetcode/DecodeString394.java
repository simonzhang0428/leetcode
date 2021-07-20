package leetcode;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> intStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                intStack.push(k);
                k = 0;
                strStack.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = sb;
                sb = strStack.pop();
                // for (int i = 0; i < intStack.pop(); i++)
                // you need to get the size first
                for (int i = intStack.pop(); i > 0; i--) {
                    sb.append(tmp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

public class DecodeString394 {

    public static void main(String[] args) {
        String ret = new Solution().decodeString("3[a]2[bc]");
        System.out.println("aaabcbc: " + ret);
    }
}