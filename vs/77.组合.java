import java.util.*;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
/**
 *  构造从小到大的数字，1-4，选2，12 == 21，要去重
 * 12，13，14
 * 23，24
 * 34
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solutions = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        dfs(n, k, 1, comb, solutions);

        return solutions;
    }

    private void dfs(int n, int k, int start, List<Integer> comb, List<List<Integer>> solutions) {
        if (comb.size() == k) {
            solutions.add(new ArrayList<>(comb));
            return;
        }

        if (comb.size() + n - start + 1 < k) {
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            dfs(n, k, i + 1, comb, solutions);
        }
    }
}
// @lc code=end

