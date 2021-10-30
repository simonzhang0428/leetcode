/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1)
            return false;
        int length = s.length();
        StringBuilder subStringBuilder = new StringBuilder();
        int maxSublength = length / 2;

        for (int i = 0; i < maxSublength; i++) {
            subStringBuilder.append(s.charAt(i));
            int curLength = i + 1;
            if (length % curLength != 0)
                continue;

            int times = length / curLength;
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < times; j++)
                temp.append(subStringBuilder);
            if (temp.toString().equals(s))
                return true;
        }
        
        return false;
    }
}


// @lc code=end

