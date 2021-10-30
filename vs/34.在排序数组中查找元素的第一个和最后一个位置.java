/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return new int[] {-1, -1};
        }
        int last = findBound(nums, target, false);
        return new int[] {first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == start || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1; // 画图，记得update
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
// @lc code=end

