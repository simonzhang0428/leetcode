import java.util.*;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (res.size() < m * n) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;

            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            down--;

            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
// @lc code=end

