public class IsPowerOfTwo231 {
    public static void main(String[] args) {
        System.out.println("false:  " + new Solution231().isPowerOfTwo(17));
    }
}

class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        // for (int i = n; i > 1; i /= 2) {
        //     if (i % 2 != 0) {
        //         return false;
        //     }
        // }
        // return true;
        return (n & (n - 1)) == 0;
    }
}