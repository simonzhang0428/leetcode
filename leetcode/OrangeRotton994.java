package leetcode;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution944 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        final int[][] DIRS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int minute = 0;
        while (freshCount > 0 && !queue.isEmpty()) {
            minute++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = tmp[0] + DIRS[j][0];
                    int newY = tmp[1] + DIRS[j][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshCount--;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }

        if (freshCount > 0) {
            return -1;
        }
        return minute;
    }

}

public class OrangeRotton994 {
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        System.out.println("4:  " + new Solution944().orangesRotting(grid));
    }
}
