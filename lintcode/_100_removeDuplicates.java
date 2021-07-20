package lintcode;

public class _100_removeDuplicates {
    public class Solution {
        /*
         * @param nums: An ineger array
         * 
         * @return: An integer
         */
        /*
         * idx 0 1 2 3 N 1 2 3 3 s f return 3
         */
        // to the left of slow (excluding slow) is the final answer
        // fast index to scan the string (from left to right)
        public int removeDuplicates(int[] nums) {
            // write your code here
            int n = nums.length;
            if (n <= 1) {
                return n;
            }
            int slow = 1, fast = 1;
            while (fast < nums.length) {
                if (nums[slow - 1] != nums[fast]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }

            return slow;
        }
    }
}
