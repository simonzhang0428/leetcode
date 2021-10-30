import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    /** 1123 secret
     *  0111 guess
     *          0    1   2   3
     * count =  -1  -1   1   1    
     * cows = 1
     */
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls = 0, cows = 0, n = guess.length();
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                if (count[s - '0'] < 0) {
                    cows++;
                }
                if (count[g - '0'] > 0) {
                    cows++;
                }

                count[s - '0']++;
                count[g - '0']--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }
}
// @lc code=end

