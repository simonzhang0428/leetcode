package OA_amazon;

import java.util.*;

public class TransactionLogs {

    /**
     * [sender, receiver, amount]
     */
    public static List<String> test(String[] logs, int min) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> frequency = new HashMap<>();

        for (String log : logs) {
            String[] content = log.split(" ");
            String sender = content[0], receiver = content[1];
            frequency.put(sender, frequency.getOrDefault(sender, 0) + 1);
            if (!sender.equals(receiver)) {
                frequency.put(receiver, frequency.getOrDefault(receiver, 0) + 1);
            } 
        }

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() >= min) {
                res.add(entry.getKey());
            }
        }

        Collections.sort(res, (s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2));
        return res;
    }

    public static void main(String[] args) {
        String[] logs = {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
        System.out.println("[88, 99]:  " + test(logs, 2));
    }
}
