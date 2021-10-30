import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {
            if (set.remove(n)) {
                res.add(n);
            }
        }

        int n = res.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
// @lc code=end

