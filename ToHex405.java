class Solution405 {
    public String toHex(int num) {
        long n = num & 0x00000000ffffffffL; // -1 -> 4294967295
        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(map[(int) (n % 16)]);
            n = n / 16;
        }
        return num == 0 ? "0" : sb.reverse().toString();
    }
}

public class ToHex405 {
    public static void main(String[] args) {
        System.out.println("1a: " + new Solution405().toHex(26));
        System.out.println("-1: " + new Solution405().toHex(-1));
        System.out.println(Long.parseLong("4294967295", 2));
    }
}