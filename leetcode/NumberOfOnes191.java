package leetcode;
class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                ans++;
            }
            n = n >> 1;
        }
        return ans;
    }
}

public class NumberOfOnes191 {
    public static void main(String[] args) {
        System.out.println("3:  " + new Solution191().hammingWeight(11));
    }
}