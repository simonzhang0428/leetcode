package OA_amazon;

public class ValidTree {

    public static class UnionFind {
        int[] parents;
        int[] size;

        UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int n1, int n2) {
            int root1 = find(n1);
            int root2 = find(n2);
            if (size[root1] > size[root2]) {
                parents[root2] = root1;
                size[root1] += size[root2];
            } else {
                parents[root1] = root2;
                size[root2] += size[root1];
            }
        }
    }

    public static boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validTree(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } }));
    }
}
