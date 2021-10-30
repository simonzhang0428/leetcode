package OA_Citadel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {
        // id, shares, bid price, timestamp
        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 5, 5, 0), Arrays.asList(2, 7, 8, 1), Arrays.asList(3, 7, 5, 1), Arrays.asList(4, 10, 3, 3));
        int total = 8;
        List<Integer> res = test(input, total);
        // System.out.println(input);
        System.out.println("res = [3, 4]: " + res);

        // second round
        input = Arrays.asList(Arrays.asList(1, 5, 5, 0), Arrays.asList(2, 7, 8, 1), Arrays.asList(3, 7, 5, 1));
        total = 3;
        res = test(input, total);
        // System.out.println(input);
        System.out.println("res = [1, 3]: " + res);

    }

    public static List<Integer> test(List<List<Integer>> input, int total) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>( 
            (a, b) -> a.get(2) == b.get(2) ? a.get(3) - b.get(3) : b.get(2) - a.get(2));
        
        pq.addAll(input);

        while (!pq.isEmpty() && total > 0) {
            List<Integer> bid1 = pq.poll();
            int shareBid1 = bid1.get(1);

            if (!pq.isEmpty() && bid1.get(2) == pq.peek().get(2)) {
                if (total == 1) {
                    break;
                }

                List<Integer> bid2 = pq.poll();
                int shareBid2 = bid2.get(1);

                // until one of bid1 or bid2 exhausted
                while (total > 0 && shareBid1-- > 0 && shareBid2-- > 0) {
                    total -= 2;
                }

                // in case bid1 still have share need
                while (total > 0 && shareBid1-- > 0) {
                    total--;
                }
                while (total > 0 && shareBid2-- > 0) {
                    total--;
                }

            } else {
                total -= shareBid1;
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll().get(0));
        }
        Collections.sort(res);
        
        return res;
    }

    public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        if (bids.size() == 0 || totalShares == 0)
            return result;

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
                (a, b) -> a.get(2) == b.get(2) ? a.get(3) - b.get(3) : b.get(2) - a.get(2));

        for (List<Integer> bid : bids)
            queue.add(bid);

        while (!queue.isEmpty() && totalShares > 0) {
            List<Integer> bid = queue.poll();
            List<Integer> bid2 = new ArrayList<>();
            int numOfShares2 = 0;

            if (!queue.isEmpty()) {
                bid2 = queue.peek();
                numOfShares2 = bid2.get(1);
            }

            int numOfShares = bid.get(1);

            if (numOfShares == numOfShares2) { // 只有相等才poll，没道理
                queue.poll();

                while (numOfShares > 0 || numOfShares2 > 0) {
                    if (numOfShares > 0 && numOfShares2 > 0)
                        totalShares -= 2;
                    else
                        totalShares -= 1;

                    if (totalShares <= 0) {
                        totalShares = 0;
                        break;
                    }
                }
            } else
                totalShares -= numOfShares;
        }

        while (!queue.isEmpty()) {
            List<Integer> bid = queue.poll();
            result.add(bid.get(0));
        }

        Collections.sort(result);

        return result;
    }
}
