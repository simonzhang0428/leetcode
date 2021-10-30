package OA_Citadel;
import java.util.*;

public class ProcessScheduling {

    public static int minimumTime(List<Integer> ability, int processes) {
        // variable to store the final minimum time
        int minTime = 0;

        while (processes > 0) { // while there are still processes left
            int index = ability.indexOf(Collections.max(ability)); // find the index of maximum ability processor
            int numProcesses = ability.get(index); // maximum ability value
            processes -= numProcesses; // update number of processes left
            ++minTime; // increment time used
            ability.set(index, numProcesses / 2); // update new ability of the max ability processor
        }

        return minTime;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 7, 2, 4);
        System.out.println("4: " + minimumTime(input, 15));
    }
    
}
