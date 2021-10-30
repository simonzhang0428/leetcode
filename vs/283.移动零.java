/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
            } else {
                nums[index++] = nums[j];
                j++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

