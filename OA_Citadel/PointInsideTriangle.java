package OA_Citadel;

// JAVA Code for Check whether a given point
// lies inside a triangle or not
import java.util.*;

public class PointInsideTriangle {
    public static void main(String[] args) {
        int ax = 2, ay = 2, bx = 7, by = 2, cx = 5, cy = 4, px = 4, py = 3, qx = 7, qy = 4;
        int res = test(ax, ay, bx, by, cx, cy, px, py, qx, qy);
        System.out.println("1: " + res);
        System.out.println("2: " + test(ax, ay, bx, by, cx, cy, 3, 3, 5, 3));
    }

    public static int test(int ax, int ay, int bx, int by, int cx, int cy, int px, int py, int qx, int qy) {
        if (!canFormTriangle(ax, ay, bx, by, cx, cy)) {
            return 0;
        }
        boolean isPInside = isInside(ax, ay, bx, by, cx, cy, px, py);
        boolean isQInside = isInside(ax, ay, bx, by, cx, cy, qx, qy);
        if (isPInside && !isQInside) {
            return 1;
        } else if (!isPInside && isQInside) {
            return 2;
        } else if (isPInside && isQInside) {
            return 3;
        } else {
            return 4;
        }
    }

    public static boolean canFormTriangle(int ax, int ay, int bx, int by, int cx, int cy) {
        double AB = Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
        double BC = Math.sqrt((cx - bx) * (cx - bx) + (cy - by) * (cy - by));
        double AC = Math.sqrt((ax - cx) * (ax - cx) + (ay - cy) * (ay - cy));

        return (AB + BC > AC) && (AB + AC > BC) && (BC + AC > AB);
    }

    public static double getArea(int ax, int ay, int bx, int by, int cx, int cy) {
        return 0.5 * Math.abs(ax * by + bx * cy + cx * ay - ax * cy - bx * ay - cx * by);
    }

    public static boolean isInside(int ax, int ay, int bx, int by, int cx, int cy, int x, int y) {
        double area1 = getArea(ax, ay, bx, by, x, y);
        double area2 = getArea(ax, ay, cx, cy, x, y);
        double area3 = getArea(bx, by, cx, cy, x, y);
        double totalArea = getArea(ax, ay, bx, by, cx, cy);

        return Double.compare((area1 + area2 + area3), totalArea) == 0;
    }

}