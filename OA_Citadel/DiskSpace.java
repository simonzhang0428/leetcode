package OA_Citadel;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class DiskSpace {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(8, 2, 4, 6);
        System.out.println("4: " + test(input, 2));
    }

    /**
     *  0   1   2   3   size = 4, k = 2
     *  8   2   4   6   [8, 2]  2   [1]
     *                  [2, 4]  2   []
     *                  [4, 6]  4   return 4
     */
    public static int test(List<Integer> input, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            int startIndex = i - k + 1;

            // maintain at most k-1 size deque
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            // maintain the queue increasing
            while (!deque.isEmpty() && input.get(i) <= input.get(deque.peekLast())) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // first one is the minimum index
            if (startIndex >= 0) {
                list.add(input.get(deque.peekFirst()));
            }
        }

        System.out.println(list);

        return Collections.max(list);
    }
    
}
