/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    /**
     * 0 1 2 3 4 5 6 
     * a 2 b 4 c b c
     *             i 
     *             j
     *           idx 
     * c = 
     * freq = 
     */
    public int compress(char[] chars) {
        int i = 0, j = 0;
        int index = 0;
        while (i < chars.length) {
            char c = chars[i];
            chars[index++] = c;
            j = i;
            while (j < chars.length && chars[j] == c) {
                j++;
            }
            int freq = j - i;
            if (freq != 1 && freq < 10) {
                chars[index++] = (char)(freq + '0');
            } else if (freq >= 10) {
                String freqString = String.valueOf(freq);
                for (int k = 0; k < freqString.length(); k++) {
                    chars[index++] = freqString.charAt(k);
                }
            }
            i = j;
        }
        return index;
    }
}

// @lc code=end

