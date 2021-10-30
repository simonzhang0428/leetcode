package OA_Citadel;

import java.util.*;

public class SongPair {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        Collections.addAll(input, 20, 40, 60);
        System.out.println("1: " + test(input));
    }

    public static int test(List<Integer> time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int t : time) {
            if (map.containsKey((60 - t % 60) % 60)) {
                count += map.get((60 - t % 60) % 60);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return count;
    }
    
}
