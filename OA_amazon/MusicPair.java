package OA_amazon;

import java.util.*;

public class MusicPair {
    public static void main(String[] args) {
        int[] songDurations = {1, 10, 30, 25, 60};
        int[] res = musicPair(90, songDurations);
        System.out.println(res[0] + "  " + res[1]);
    }

    /**
     * pick 2 songs, sum == duration - 30, if have many, choose the pair
     * with longest song
     * @param duration
     * @param songDurations
     * @return
     */
    public static int[] musicPair(int duration, int[] songDurations) {
        int[] res = new int[]{-1, -1};
        if (duration <= 30 || songDurations == null || songDurations.length < 2) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int target = duration - 30;
        int validLongest = Integer.MIN_VALUE;

        for (int i = 0; i < songDurations.length; i++) {
            int cur = songDurations[i];
            if (map.containsKey(target - cur) && cur > validLongest) {
                res[0] = map.get(target - cur);
                res[1] = i;
                validLongest = cur;
            }
            map.put(cur, i);
        }
        
        return res;
    }
}
