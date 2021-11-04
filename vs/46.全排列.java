import java.util.*;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int begin) {
        // base case, add whole path to result here
        if (begin == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                path.add(nums[i]);
            }
            result.add(path);
        }

        // in-place, before begin not change
        for (int i = begin; i < nums.length; i++) {
            swap(nums, begin, i);
            dfs(nums, result, begin + 1);
            swap(nums, begin, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
