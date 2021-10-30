package OA_amazon;

public class UntilizatioinCheck {
    public static void main(String[] args) {
        int[] averageUtil = {25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80};
        System.out.println("2:  " + finalInstance(2, averageUtil));
    }

    public static int finalInstance(int instance, int[] averageUtil) {
        for (int i = 0; i < averageUtil.length; i++) {
            int value = averageUtil[i];
            if (value >= 25 && value <= 60) {
                continue;
            }
            if (value < 25) {
                if (instance > 1) {
                    instance = instance % 2 == 0 ? instance / 2 : instance / 2 + 1;
                }
            } else {
                if (instance * 2 <= 200000000) {
                    instance = instance * 2;
                }
            }
            i += 10;
        }
        return instance;
    }
}
