/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        helper(0, n-1, 1, n, res);
        return res;
    }

    private void helper(int l, int h, int sum, int n, int[][] res) {
        for (int i = l; i <= h; i++) {
            res[l][i] = sum++;
        }
        for (int j = l + 1; j <= h; j++) {
            res[j][h] = sum++;
        }
        for (int k = h - 1; k >= l; k--) {
            res[h][k] = sum++;
        }
        for (int q = h - 1; q >= l; q--) {
            res[q][l] = sum++;
        }
        if (sum <= n * n) {
            helper(l+1, h-1, sum, n, res);
        }
    }

}
// @lc code=end

