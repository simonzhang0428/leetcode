package leetcode;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || !stack.isEmpty() && temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int prev = stack.poll();
                    result[prev] = i - prev;
                } // stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]
                stack.push(i);
            }
        }

        return result;
    }
}

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new Solution739().dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + "  ");
        }
    }
}