package leetcode;
class Solution190 {
    // you need treat n as an unsigned value
    /*
        1000 ... 1110
        l ->     <- r
        1 ...       1
    xor --------------
        0 ...       1
    */
    public int reverseBits(int n) {
        int left = 31;
        int right = 0;
        while (left > right) {
            if (((n >> left) & 1) != ((n >> right) & 1)) {
                n = (n ^ (1 << left));
                n = (n ^ (1 << right));
            }
            left--;
            right++;
        }
        return n;
    }
}

public class ReverseBits190 {
    public static void main(String[] args) {
        int n = Integer.parseInt("00000010100101000001111010011100", 2);
        System.out.println("964176192:  " + new Solution190().reverseBits(n));
    }
}