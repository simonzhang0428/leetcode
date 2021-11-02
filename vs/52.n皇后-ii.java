import java.util.Set;

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start

class Solution {
        /**
    def backtrack_nqueen(row = 0, count = 0):
        for col in range(n):
            # iterate through columns at the curent row.
            if is_not_under_attack(row, col):
                # explore this partial candidate solution, and mark the attacking zone
                place_queen(row, col)
                if row + 1 == n:
                    # we reach the bottom, i.e. we find a solution!
                    count += 1
                else:
                    # we move on to the next row
                    count = backtrack(row + 1, count)
                # backtrack, i.e. remove the queen and remove the attacking zone.
                remove_queen(row, col)
        return count
     */
    
    // Global variable inside solution class
    private int size;
    private final Set<Integer> cols = new HashSet<>();
    private final Set<Integer> diag = new HashSet<>();
    private final Set<Integer> anitDiag = new HashSet<>();

    public int totalNQueens(int n) {
        this.size = n;

        return backtrack(0);
    }

    private int backtrack(int row) {
        
        int solutions = 0;
        for (int col = 0; col < size; col++) {
            if (cols.contains(col) || diag.contains(row + col) || anitDiag.contains(row - col)) {
                continue;
            }
            
            if (row + 1 == size) {
                return 1;
            } else {
                cols.add(col);
                diag.add(row + col);
                anitDiag.add(row - col);
    
                solutions += backtrack(row + 1); 
    
                cols.remove(col);
                diag.remove(row + col);
                anitDiag.remove(row - col);
            }

        }

        return solutions;
    }
}
// @lc code=end

