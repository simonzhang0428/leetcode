/*
 * @lc app=leetcode.cn id=640 lang=java
 *
 * [640] 求解方程
 */

// @lc code=start
class Solution {
    public String solveEquation(String equation) {
        String[] partition = equation.split("=");
        String left = partition[0], right = partition[1];
        int[] leftInfo = combine(left);
        int[] rightInfo = combine(right);

        int totalX = leftInfo[0] - rightInfo[0];
        int totalNum = rightInfo[1] - leftInfo[1];

        System.out.println(leftInfo[0] + "  " + leftInfo[1] + " " + rightInfo[0] + "  " + rightInfo[1]);

        if (totalX == 0 && totalNum != 0) {
            return "No solution";
        }
        if (totalX == 0 && totalNum == 0) {
            return "Infinite solutions";
        }

        int result = totalNum / totalX;
        return "x=" + result;

    }

    private int[] combine(String s) {
        int xCount = 0, totalNum = 0;
        boolean isPositive = true;
        StringBuilder currX = new StringBuilder(), currNum = new StringBuilder();

        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == 'x') {
                i--;
                if (i == -1 || i >= 0 && s.charAt(i) == '+') {
                    xCount++;
                    i--;
                    continue;
                } else if (i >= 0 && s.charAt(i) == '-') {
                    xCount--;
                    i--;
                    continue;
                }
                while (i >= 0 && s.charAt(i) != '+' && s.charAt(i) != '-') {
                    currX.append(s.charAt(i));
                    i--;
                }
                if (i >= 0 && s.charAt(i) == '-') {
                    isPositive = false;
                }
                i--;
                xCount = isPositive ? xCount + Integer.valueOf(currX.reverse().toString()) 
                        : xCount - Integer.parseInt(currX.reverse().toString());
                currX.setLength(0);
                isPositive = true;
            } else {
                while (i >= 0 && s.charAt(i) != '+' && s.charAt(i) != '-') {
                    currNum.append(s.charAt(i));
                    i--;
                }
                if (i >= 0 && s.charAt(i) == '-') {
                    isPositive = false;
                }
                i--;
                totalNum = isPositive ? totalNum + Integer.valueOf(currNum.reverse().toString())
                        : totalNum - Integer.parseInt(currNum.reverse().toString());
                currNum.setLength(0);
                isPositive = true;
            }
        }
        return new int[] { xCount, totalNum };
    }
}
// @lc code=end
