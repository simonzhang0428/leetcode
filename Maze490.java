import java.util.ArrayDeque;
import java.util.Queue;

class Solution490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start[0] * n + start[1]);
        visited[start[0]][start[1]] = true;

        int[] dirs = { -1, 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur / n, y = cur % n;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    x += dirs[i];
                    y += dirs[i + 1];
                }
                x -= dirs[i];
                y -= dirs[i + 1];

                if (x == destination[0] && y == destination[1]) {
                    return true;
                }

                if (!visited[x][y]) {
                    queue.offer(x * n + y);
                    visited[x][y] = true;
                }
            }
        }

        return false;
    }
}

public class Maze490 {
    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0}};
        int[] start = {0,4};
        int[] end = {4,4};
        System.out.println("true:   " + new Solution490().hasPath(maze, start, end));
    }
}