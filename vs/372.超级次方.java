/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
// https://leetcode-cn.com/problems/super-pow/solution/you-qian-ru-shen-kuai-su-mi-suan-fa-xiang-jie-by-l/
class Solution {
    int base = 1337;

    public int superPow(int a, int[] b) {
        int len = b.length;
        int ans = indexPow(a, b, len);
        return ans;
    }

    // a的k次方对base取模
    private int myPow(int a, int k) {
        a %= base;
        int ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= a;
            ans %= base;
        }
        return ans;
    }

    // 加入index判断是否需要终止递归
    private int indexPow(int a, int[] b, int index) {
        if (index < 1)
            return 1;

        int part1 = myPow(a, b[index - 1]);
        index--;
        int part2 = myPow(indexPow(a, b, index), 10);

        return part1 * part2 % base;
    }
}
// @lc code=end

