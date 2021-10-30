import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        Queue<Integer> pq = new PriorityQueue<>(
            (a, b) -> count[b] - count[a]
        );

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int ch = pq.poll();
            int freq = count[ch];
            while (freq-- > 0) {
                sb.append((char)ch);
            }
        }
        return sb.toString();
    }
    // time: O(N), 
    // space: O(N), stringbuilder to constructor the answer
}
// @lc code=end

