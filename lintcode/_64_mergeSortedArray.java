package lintcode;

public class _64_mergeSortedArray {

    public class Solution {
        /*
        * @param A: sorted integer array A which has m elements, but size of A is m+n
        * 
        * @param m: An integer
        * 
        * @param B: sorted integer array B which has n elements
        * 
        * @param n: An integer
        * 
        * @return: nothing
        */
        /**
         *    0  1  2   3  4 
         * A 10 20 10  20 30 
         * i 
         * B  4  5 
         *       j
         * 
         */
        public void mergeSortedArray(int[] A, int m, int[] B, int n) {
            // write your code here
            int i = m - 1, j = n - 1;
            while (i >= 0 && j >= 0) {
                if (A[i] > B[j]) {
                    A[i + j + 1] = A[i];
                    i--;
                } else {
                    A[i + j + 1] = B[j];
                    j--;
                }
            }
            while (j >= 0) {
                A[j] = B[j];
                j--;
            }

        }
    }
}