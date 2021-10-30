package OA_amazon;

import java.util.*;

public class ShppingPattern {
    public static int getMinScore(int nodes, int edges, int[] from, int[] to) {
        Map<Integer, Integer> degree = new HashMap<>();
        boolean[][] isEdge = new boolean[nodes + 1][nodes + 1];

        for (int i = 0; i < edges; i++) {
            degree.put(from[i], degree.getOrDefault(from[i], 0) + 1);
            degree.put(to[i], degree.getOrDefault(to[i], 0) + 1);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < edges; i++) {
            int a = from[i];
            int b = to[i];
            for (int j = 1; j <= nodes; j++) {
                if (isEdge[a][j] && isEdge[b][j]) {
                    int d = degree.get(a) + degree.get(b) + degree.get(j) - 6;
                    res = Math.min(res, d);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] from = {1, 2, 2, 3, 4, 5};
        int[] to = {2, 4, 5, 5, 5, 6};
        int[][] edges = {{1, 2, 2, 3, 4, 5}, {2, 4, 5, 5, 5, 6}};
        System.out.println("3:  " + getMinScore(6, 6, from, to));
        System.out.println("3:  " + minTrioDegree(6, edges));
    }

    public static int minTrioDegree(int n, int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }

        int[] inDegree = new int[n + 1];
        boolean[][] flag = new boolean[n + 1][n + 1];
        for (int[] edge : edges) {
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;

            flag[edge[0]][edge[1]] = true;
            flag[edge[1]][edge[0]] = true;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!flag[i][j] && !flag[j][i]) {
                    continue;
                }
                for (int k = j + 1; k <= n; k++) {
                    if (flag[j][k] && flag[k][j] && flag[i][k] && flag[k][i]) {
                        int count = inDegree[i] + inDegree[j] + inDegree[k] - 3 * 2;
                        minCount = Math.min(minCount, count);
                    }
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

}
