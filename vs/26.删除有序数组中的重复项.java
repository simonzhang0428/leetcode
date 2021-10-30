/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 1, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == prev) {
                i++;
            }
            if (i == nums.length) {
                break;
            }
            prev = nums[i];
            nums[index++] = nums[i];
        }

        return index;
    }
}
// @lc code=end

