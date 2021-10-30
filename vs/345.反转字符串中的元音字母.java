import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {

    public String reverseVowels(String s) {
        var set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        var cs = s.toCharArray();
        int left = 0, right = cs.length - 1;
        while (left < right) {
            while (left < right && !set.contains(cs[left])) {
                left++;
            }
            while (left < right && !set.contains(cs[right])) {
                right--;
            }

            swap(cs, left++, right--);
        }
        
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }
}
// @lc code=end

