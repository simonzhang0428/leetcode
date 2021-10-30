import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // freq map
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // bucket sort on freq
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int pos = buckets.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (buckets[pos] != null) {
                res.addAll(buckets[pos]);
            }
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i : res) {
            ans[index++] = i;
        }

        return ans;
    }
}


// @lc code=end

