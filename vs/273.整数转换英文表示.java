/*
 * @lc app=leetcode.cn id=273 lang=java
 *
 * [273] 整数转换英文表示
 */

// @lc code=start

class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int billions = num / 1000000000;
        num = num % 1000000000;

        int millions = num / 1000000;
        num = num % 1000000;

        int thousand = num / 1000;
        num = num % 1000;

        StringBuilder sb = new StringBuilder();
        if (billions != 0) {
            addSpace(sb);
            sb.append(find(billions));
            sb.append(" Billion");
        }

        if (millions != 0) {
            addSpace(sb);
            sb.append(find(millions));
            sb.append(" Million");
        }

        if (thousand != 0) {
            addSpace(sb);
            sb.append(find(thousand));
            sb.append(" Thousand");
        }

        if (num != 0) {
            addSpace(sb);
            sb.append(find(num));
        }
        return sb.toString();
    }

    String[] ones = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
    String[] twos = { "-", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    String[] tens = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred" };

    private String find(int num) {
        int hundred = num / 100;
        num = num % 100;

        StringBuilder sb = new StringBuilder();
        if (hundred != 0) {
            addSpace(sb);
            sb.append(ones[hundred]);
            sb.append(" Hundred");
        }

        if (num > 0 && num <= 10) {
            addSpace(sb);
            sb.append(ones[num]);
        } else if (num > 10 && num < 20) {
            addSpace(sb);
            sb.append(twos[num % 10]);
        } else if (num >= 20) {
            int two = num / 10;
            num = num % 10;
            addSpace(sb);
            sb.append(tens[two - 1]);
            if (num != 0) {
                sb.append(" ");
                sb.append(ones[num]);
            }
        }

        return sb.toString();
    }

    private void addSpace(StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append(" ");
        }
    }
}
// @lc code=end

