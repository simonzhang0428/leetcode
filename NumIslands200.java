import java.util.ArrayDeque;
import java.util.Queue;

class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (!isValid(grid, x, y) || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);

    }

    private boolean isValid(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return true;
    }


    // bfs
    public int numIslands_bfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        final int[][] DIR = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, DIR, queue);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y, int[][] DIR, Queue<int[]> queue) {
        queue.offer(new int[] { x, y });
        grid[x][y] = '0';
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] direction : DIR) {
                int nextX = cur[0] + direction[0];
                int nextY = cur[1] + direction[1];
                if (isValid(grid, nextX, nextY) && grid[nextX][nextY] == '1') {
                    queue.offer(new int[] { nextX, nextY });
                    grid[nextX][nextY] = '0';
                }
            }
        }
    }

}

public class NumIslands200 {
    
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int ret = new Solution200().numIslands(grid);
        System.out.println(ret);
    }
}
