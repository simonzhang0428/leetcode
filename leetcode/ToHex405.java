package leetcode;
class Solution405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long n = num & 0x00000000ffffffffL; // -1 -> 2^32 − 1 = 4294967295.
        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(map[(int) (n % 16)]);
            n = n / 16;
        }
        return sb.reverse().toString();
    }
}

class Solution405_2 {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        char[] map = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}

public class ToHex405 {
    public static void main(String[] args) {
        System.out.println("1a: " + new Solution405().toHex(26));
        System.out.println("ffffffff: " + new Solution405_2().toHex(-1));
        int m = -255;
        System.out.println(Integer.toString(m, 16));
        System.out.println("m >>> 4:    " + (m >>> 4));
        System.out.println("m >> 4:    " + (m >> 4));
    }
}