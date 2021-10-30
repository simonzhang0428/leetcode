import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int c1 = 0, c2 = 0, nums1 = 0, nums2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums1) {
                c1++;
            } else if (nums[i] == nums2) {
                c2++;
            } else if (c1 == 0) {
                nums1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                nums2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums1) {
                c1++;
            } else if (nums[i] == nums2) {
                c2++;
            }
        }

        if (c1 > nums.length / 3) {
            res.add(nums1);
        }
        if (c2 > nums.length / 3) {
            res.add(nums2);
        }

        return res;
    }
}
// @lc code=end

