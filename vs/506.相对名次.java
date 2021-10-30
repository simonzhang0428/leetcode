import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        int[] s = Arrays.copyOf(nums, n);

        Arrays.sort(s);

        String[] ans = new String[n];
        String[] medals = { "Gold Medal", "Silver Medal", "Bronze Medal" };

        for (int i = 0; i < n; i++) {
            int rank = n - Arrays.binarySearch(s, nums[i]);
            if (rank <= 3) {
                ans[i] = medals[rank - 1];
            } else {
                ans[i] = Integer.toString(rank);
            }
        }
        return ans;
    }
}
// @lc code=end

