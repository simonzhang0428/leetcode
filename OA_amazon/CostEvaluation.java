package OA_amazon;

import java.util.*;

public class CostEvaluation {
    public static void main(String[] args) {
        int[][] connections = {{0, 2}, {1, 2}};
        int[][] conn1 = new int[][] { { 2, 6 }, { 3, 5 }, { 0, 1 }, { 2, 9 }, { 5, 6 } };

        int res = costEvaluation(4, connections);
        int res2 = costEvaluation(10, conn1);

        System.out.println("3: " + res);
        System.out.println("8: " + res2);
    }

    public static int costEvaluation(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            
            List<Integer> connects0 = graph.getOrDefault(connection[0], new ArrayList<>());
            connects0.add(connection[1]);
            graph.put(connection[0], connects0);

            List<Integer> connects1 = graph.getOrDefault(connection[1], new ArrayList<>());
            connects1.add(connection[0]);
            graph.put(connection[1], connects1);

            // graph.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            // graph.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
        }

        Set<Integer> visited = new HashSet<>();
        // each unconnected warehouse has a cost of 1
        int cost = n - graph.size();

        for (int v : graph.keySet()) {
            if (visited.contains(v)) {
                continue;
            }

            int connLength = visitConnected(graph, visited, v);
            cost += (int) Math.ceil(Math.sqrt(connLength));
        }
        // System.out.println(graph.toString());
        return cost;
    }

    private static int visitConnected(Map<Integer, List<Integer>> graph, Set<Integer> visited, int vertex) {
        visited.add(vertex);

        int length = 1;
        for (int adjVertex : graph.get(vertex)) {
            if (visited.contains(adjVertex)) {
                continue;
            }

            length += visitConnected(graph, visited, adjVertex);
        }
        
        return length;
    }

    // public int test(int n, int[][] connections) {
    //     int[] met = new int[n];
    //     Arrays.fill(met, 1); // 1 is met, 0 is no
    //     Map<Integer, Set<Integer>> connMap = new HashMap<>();
    //     constructConn(connections, connMap);
    //     int sum = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (met[i] == 0) {
    //             continue;
    //         }
    //         int[] neighbour = new int[]{1};
    //         met[i] = 0;
    //         bfs(neighbour, met, new ArrayList<>(i), connMap);
    //         sum += Math.ceil(Math.sqrt(neighbour[0]));
    //     }
    //     return sum;
    // }

    // public void bfs(int[] res, int[] met, List<Integer> startHouses, Map<Integer, Set<Integer> connMap) {
    //     List<Integer> newConnHouses = new ArrayList<>();
    //     for (Integer house : startHouses) {
    //         Set<Integer> connectedHouses = connMap.getOrDefault(house, null);
    //         if (connectedHouses == null) continue;
    //         for (Integer connHouse : connectedHouses) {
    //             if (met[connHouse] == 0) {
    //                 continue;
    //             }
    //             res[0] ++;
    //             newConnHouses.add(connHouse);
    //             met[connHouse] = 0;
    //         }
    //     }
    //     if (newConnHouses.isEmpty()) {
    //         return;
    //     }
    //     bfs(res, met, newConnHouses, connMap);
    // }

    // // set.contains(key) == O(1)
    // /**
    //  * {0: (2), 1: (2)}
    //  */
    // public static void constructConn(int[][] connections, Map<Integer, Set<Integer>> map) {
    //     for (int[] conn : connections) {
    //         map.get(conn[0]).add(conn[1]);
    //     }
    // }

    // /**
    //  * 相连的group有k户人家，total cost 是ceiling of sqrt(k)
    //  * @param n, 0 - n-1 个node
    //  * @param connections, 互相连接关系
    //  * @return total cost
    //  */
    // public static int costEvaluation(int n, int[][] connections) {
    //     // set up adjacency list
    //     Map<Integer, List<Integer>> adj = new HashMap<>();
    //     for (int i = 0; i < n; i++) {
    //         adj.put(i, new ArrayList<Integer>());
    //     }
    //     for (int[] connection : connections) {
    //         adj.get(connection[0]).add(connection[1]);
    //         adj.get(connection[1]).add(connection[0]);
    //     }

    //     boolean[] visited = new boolean[n];

    //     int sum = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (visited[i]) {
    //             continue;
    //         }
    //         int[] neighbour = new int[]{1};
    //         bfsHelper(neighbour, visited, i);
    //         sum += (int)Math.ceil(Math.sqrt(neighbour[0]));
    //         visited[i] = true;
    //     }
    //     return sum;
    // }

    // private static void bfsHelper(int[] neighbour, boolean[] visited, int i, Map<Integer, List<Integer>> adj) {
    //     visited[i] = true;

    //     for (Integer j : adj.get(i)) {
    //         if (!visited[j]) {
    //             dfs(adj, j, visited);
    //         }
    //     }
    // }
}
