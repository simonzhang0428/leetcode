package OA_Goldman;

public class ReachingPoints {
    /**
     * (x, y) -> (x+y, y)
     * (x, y) -> (x, x+y)
     * return: Yes, No
     */
    public static String canReach(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty)
                break;
            if (tx > ty) {
                if (ty > sy)
                    tx %= ty;
                else
                    return (tx - sx) % ty == 0 ? "Yes" : "No";
            } else {
                if (tx > sx)
                    ty %= tx;
                else
                    return (ty - sy) % tx == 0 ? "Yes" : "No";
            }
        }
        return (tx == sx && ty == sy) ? "Yes" : "No";
    }

    public static void main(String[] args) {
        System.out.println("Yes: " + canReach(1, 4, 5, 9));
    }
}
