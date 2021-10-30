/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        /**
        // State transitions
        //  0 : dead to dead
        //  1 : live to live
        //  2 : live to dead
        //  3 : dead to live
         */
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbour = count(i, j, board);

                // rule 1
                if (board[i][j] == 1 && neighbour < 2) {
                    board[i][j] = 2;
                }

                // rule 2
                else if (board[i][j] == 1 && (neighbour == 2 || neighbour == 3)) {
                    board[i][j] = 1;
                }

                // rule 3
                else if (board[i][j] == 1 && neighbour > 3) {
                    board[i][j] = 2;
                }
                
                // rule 4
                else if (board[i][j] == 0 && neighbour == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }

    private int count(int i, int j, int[][] board) {
        int count = 0;
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                if (board[x][y] == 1 || board[x][y] == 2) { // 1 and 2 means live at first
                    count++;
                }
            }
        }
        return count;
    }
    // O(N), O(N)
}
// @lc code=end

