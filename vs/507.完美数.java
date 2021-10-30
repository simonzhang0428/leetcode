/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {

    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum - num == num;
    }
    // O(sqrt(N))

}
// @lc code=end
