package OA_amazon;

import java.util.*;

public class TreasureIsland {
    public static void main(String[] args) {
        char[][] grid = {{'O', 'O', 'O', 'O'}, 
                        {'D', 'O', 'D', 'O'},
                        {'O', 'O', 'O', 'O'}, 
                        {'X', 'D', 'D', 'O'}};
        System.out.println("5: " + minSteps(grid));

        char[][] grid2 = { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' }, { 'O', 'O', 'O', 'O', 'X' },
                { 'X', 'D', 'D', 'O', 'O' }, {'X', 'D', 'D', 'D', 'O'} };
        System.out.println("3: " + minSteps2(grid2));

    }

    public static int minSteps(char[][] grid) {
        int[] dirs = {-1, 0, 1, 0, -1};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 'D';
        int steps = 0;
        // 2nd way 
        while (!queue.isEmpty()) { // 能够到的就放进去，queue等于当前不走动都能够到的岛屿！
            int size = queue.size();
            for (int i = 0; i< size;i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                if (grid[x][y] == 'X') return steps;
                grid[x][y] = 'D';
                for (int k = 0; k < 4; k++) {
                    int dx = x + dirs[k];
                    int dy = y + dirs[k + 1];
                    if (dx < 0 || dx >= m || dy < 0 || dy >=n || grid[dx][dy] == 'D') {
                        continue;
                    }
                    queue.offer(new int[]{dx, dy});
                }
            }
            steps++;
        }
        // int steps = 0;
        // while (!queue.isEmpty()) {
        //     steps++;
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         int[] cur = queue.poll();
        //         int x = cur[0], y = cur[1];
        //         for (int k = 0; k < 4; k++) {
        //             int dx = x + dirs[k];
        //             int dy = y + dirs[k + 1];
        //             if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] != 'D') {
        //                 if (grid[dx][dy] == 'X') {
        //                     return steps;
        //                 }
        //                 grid[dx][dy] = 'D';
        //                 queue.offer(new int[]{dx, dy});
        //             }
        //         }
        //     }
        // }
        return -1;
    }

    public static int minSteps2(char[][] grid) {
        int[] dirs = { -1, 0, 1, 0, -1 };
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    queue.offer(new int[] { i, j });
                    grid[i][j] = 'D';
                }
            }
        }
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int k = 0; k < 4; k++) {
                    int dx = x + dirs[k];
                    int dy = y + dirs[k + 1];
                    if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] != 'D') {
                        if (grid[dx][dy] == 'X') {
                            return steps;
                        }
                        grid[dx][dy] = 'D';
                        queue.offer(new int[] { dx, dy });
                    }
                }
            }
        }
        return -1;
    }
}
