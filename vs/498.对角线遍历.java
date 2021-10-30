import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        /**
         * on the same diagonal sum(x, y) is the same
         * use treemap, ordered by key(sum)
         */
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(mat[i][j]);
            }
        }

        int k = 0;
        for (Integer i : map.keySet()) {
            List<Integer> cur = map.get(i);
            if (i % 2 == 0) {
                Collections.reverse(cur);
            }
            for (int num : cur) {
                res[k++] = num;
            }
        }

        return res;
    }
}
// @lc code=end

