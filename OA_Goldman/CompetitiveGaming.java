package OA_Goldman;

import java.util.*;
import java.util.Collections;

public class CompetitiveGaming {
    public static void main(String[] args) {
        List<Integer> score = new ArrayList<>();
        score.add(100);
        score.add(50);
        score.add(50);
        score.add(25);

        System.out.println("3: " + levelUp(3, score));
    }

    public static int levelUp(int k, List<Integer> score) {
        if (k <= 0)
            return 0;
        Collections.sort(score, Collections.reverseOrder());
        int rank = 1;
        int res = 0;
        for (int i = 0; i < score.size(); i++) {
            if (i == 0) {
                rank = 1;
            } else if (score.get(i) != score.get(i - 1)) {
                rank = i + 1;
            }
            
            if (rank <= k && score.get(i) > 0)
                res++;
            else
                break;
        }
        return res;
    }
}
