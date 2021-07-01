import java.util.ArrayDeque;
import java.util.Queue;

class Solution785 {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }

            queue.offer(i);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int u : graph[v]) {
                    if (visited[u] == visited[v]) {
                        return false;
                    }
                    if (visited[u] == 0) {
                        visited[u] = -visited[v];
                        queue.offer(u);
                    }
                }
            }
        }

        return true;
    }

    public boolean isBipartite_dfs(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return true;
        }
        int[] visited = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            if (visited[i] == 0 && !isBipartite_dfs(visited, grid, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite_dfs(int[] visited, int[][] grid, int v, int curColor) {
        if (visited[v] != 0) {
            return visited[v] == curColor;
        }
        visited[v] = curColor;
        for (int nei : grid[v]) {
            if (!isBipartite_dfs(visited, grid, nei, -curColor)) {
                return false;
            }
        }
        return true;
    }
}

public class IsBipartite785 {
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };
        boolean ret = new Solution785().isBipartite_dfs(graph);
        System.out.println("false: " + ret);
    }
}
