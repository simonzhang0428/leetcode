/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3)
            return false;
        for (int j = 1; j <= n / 2; j++) {
            for (int k = j + 1; k < n; k++) {
                if (backtrace(num, 0, j, k)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrace(String s, int i, int j, int k) {
        if (s.charAt(i) == '0' && j - i > 1 || s.charAt(j) == '0' && k - j > 1) {
            return false;
        }
        String sum = add(s.substring(i, j), s.substring(j, k));
        if (sum.length() > s.length() - k || !sum.equals(s.substring(k, k + sum.length()))) {
            return false;
        }
        if (sum.length() == s.length() - k) {
            return true;
        }

        return backtrace(s, j, k, k + sum.length());
    }

    public String add(String s1, String s2) {
        int n1 = s1.length() - 1;
        int n2 = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int t1 = n1 >= 0 ? (s1.charAt(n1) - '0') : 0;
            int t2 = n2 >= 0 ? (s2.charAt(n2) - '0') : 0;
            int sum = t1 + t2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            n1--;
            n2--;
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

