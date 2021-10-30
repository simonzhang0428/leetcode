package OA_Goldman;

import java.util.*;

public class RobotCycle {
    public static List<String> doesCircleExist(List<String> commands) {
        List<String> res = new ArrayList<>();

        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;
        
        for (String instructions : commands) {
            for (char i : instructions.toCharArray()) {
                if (i == 'L')
                    idx = (idx + 3) % 4;
                else if (i == 'R')
                    idx = (idx + 1) % 4;
                else {
                    x += directions[idx][0];
                    y += directions[idx][1];
                }
            }
            
            // after one cycle:
            // robot returns into initial position
            // or robot doesn't face north
            if ((x == 0 && y == 0) || (idx != 0)) {
                res.add("YES");
            } else {
                res.add("NO");
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> comm1 = new ArrayList<>();
        comm1.add("G");
        comm1.add("L");
        comm1.add("RGRG");
        System.out.println("[NO YES YES]:  " + doesCircleExist(comm1));
    }
}
