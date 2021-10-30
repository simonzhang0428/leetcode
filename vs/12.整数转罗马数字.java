import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (values[i] > num) {
                i++;
            }
            int times = num / values[i];
            for (int k = 0; k < times; k++) {
                sb.append(symbols[i]);
            }
            num -= times * values[i];
        }

        return sb.toString();
    }
}
// @lc code=end
