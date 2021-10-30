import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length(), ans = 0, i = n - 1;
        ans += map.get(s.charAt(i--));
        for (; i >= 0; i--) {
            int next = map.get(s.charAt(i + 1));
            int curr = map.get(s.charAt(i));
            if (curr < next) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }

        return ans;
    }
}
// @lc code=end

