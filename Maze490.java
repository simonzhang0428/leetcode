import java.util.ArrayDeque;
import java.util.Queue;

class Solution490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            if (s[0] == destination[0] && s[1] == destination[1]) {
                return true;
            }
            for (int[] dir : DIRS) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.offer(new int[] { x - dir[0], y - dir[1] });
                    visited[x - dir[0]][y - dir[1]] = true;
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