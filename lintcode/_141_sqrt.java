package lintcode;

public class _141_sqrt {
    public class Solution {
        /**
         * @param x: An integer
         * @return: The sqrt of x
         */
        public int sqrt(int x) {
            // write your code here
            if (x <= 1) {
                return x;
            }

            int left = 2, right = x;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (mid == x / mid) {
                    return mid;
                } else if (mid > x / mid) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            return left;
        }
    }
    
}
