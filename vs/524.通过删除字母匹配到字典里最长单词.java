/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // Collections.sort(dictionary, (a, b) -> 
        // a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        String ans = "";
        for (String word : dictionary) {
            if (isSubsequency(word, s)) {
                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }

        return ans;
    }

    private boolean isSubsequency(String s, String t) {
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }
    // O(N x K), k is average word length
    // O(K), ans is used
}
// @lc code=end

