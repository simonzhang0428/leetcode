/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    /**
     * [left, i) = 0
     * [i, j] = 1
     * (j, right] = 2
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int left = 0, right = nums.length - 1;
        while (i <= right) {
            if (nums[i] == 2 && i <= right) {
                swap(nums, i, right);
                right--;
            } else if (nums[i] == 0 && i > left) {
                swap(nums, i, left);
                left++;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

