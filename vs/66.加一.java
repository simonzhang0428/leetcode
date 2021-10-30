import java.util.Arrays;

import jdk.internal.org.jline.utils.DiffHelper.Diff;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        int[] withCarry = new int[digits.length + 1];
        withCarry[0] = 1;
        return withCarry;
    }
}
// @lc code=end

