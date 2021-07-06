class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, count = 0, left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }

            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}

public class LongestOnes1004 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println("10: " + new Solution1004().longestOnes(nums, 3));
    }
}
