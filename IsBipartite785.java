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
}

public class IsBipartite785 {
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };
        boolean ret = new Solution785().isBipartite(graph);
        System.out.println("false: " + ret);
    }
}
