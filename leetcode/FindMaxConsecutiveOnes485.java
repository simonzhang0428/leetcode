package leetcode;
class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max++;
            } else {
                globalMax = Math.max(max, globalMax);
                max = 0;
            }
        }
        return Math.max(globalMax, max);
    }
}

public class FindMaxConsecutiveOnes485 {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 1, 1};
        System.out.println("3: " + new Solution485().findMaxConsecutiveOnes(array));
    }
}