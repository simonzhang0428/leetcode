/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    /**
     *     transpose    reverse
     * 1 2 3    1 4 7   7 4 1
     * 4 5 6    2 5 8   8 5 2
     * 7 8 9    3 6 9   9 6 3
     * 
     */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[row.length - 1 - i];
                row[row.length - 1 - i] = temp;
            }
        }
    }

}
// @lc code=end

