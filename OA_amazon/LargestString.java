package OA_amazon;

import java.util.*;

public class LargestString {
    public static void main(String[] args) {
        System.out.println("zzazz: " + largestString("zzzazz", 2));
        System.out.println("ccba: " + largestString("bacc", 2));
    }
    
    private static String largestString(String s, int k) {
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : chs) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, (a, b) -> (b.getKey().compareTo(a.getKey())));

        int i = 0;
        while (i < list.size()) {
            Map.Entry<Character, Integer> firstEntry = list.get(i);
            char firstKey = firstEntry.getKey();
            int firstVal = firstEntry.getValue();

            if (firstVal > k) {
                // reduce by k
                int count = 0;
                while (count < k) {
                    sb.append(firstKey);
                    count++;
                }
                firstEntry.setValue(firstVal - k);

                // Just add 1 next character
                Map.Entry<Character, Integer> secondEntry = list.get(i + 1);
                char secondKey = secondEntry.getKey();
                int secondVal = secondEntry.getValue();

                if (secondVal > 0) {
                    sb.append(secondKey);
                    secondEntry.setValue(secondVal - 1);
                }
            } else if (firstVal > 0 && firstVal <= k) {
                int count = 0;
                while (count < firstVal) {
                    sb.append(firstKey);
                    count++;
                }
                firstEntry.setValue(0);
            } else { // firstVal == 0
                i++;
            }
        }

        return sb.toString();
    }
    
}
