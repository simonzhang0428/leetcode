class Solution50 {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = pow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        }
        return x * half * half;
    }
}

public class Pow50 {
    public static void main(String[] args) {
        System.out.println("1024: " + new Solution50().myPow(2, 10));
        System.out.println("0.25: " + new Solution50().myPow(2, -2));
    }
}