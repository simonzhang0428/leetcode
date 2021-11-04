import java.util.Set;

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start

class Solution {

    public int totalNQueens(int n) {
        List<Integer> ans = new ArrayList<>();
        boolean[] cols = new boolean[n]; // 列
        boolean[] d1 = new boolean[2 * n]; // 主对角线
        boolean[] d2 = new boolean[2 * n]; // 副对角线
        return backtrack(0, cols, d1, d2, n, 0);
    }

    private int backtrack(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n, int count) {
        if (row == n) {
            count++;
        } else {
            for (int col = 0; col < n; col++) {
                int id1 = row - col + n; // 主对角线加 n
                int id2 = row + col;
                if (cols[col] || d1[id1] || d2[id2])
                    continue;

                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;

                count = backtrack(row + 1, cols, d1, d2, n, count);
                
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }

        }
        return count;
    }

    
}
// @lc code=end

