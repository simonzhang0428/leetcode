package OA_Citadel;

import java.util.*;

public class StockPair {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(5, 7, 9, 13, 11, 6, 6, 3, 3);
        System.out.println("3: " + test2(input, 12));
    }

    public static int test(List<Integer> input, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : input) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int ans = 0;
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int stock = entry.getKey();
            int count = entry.getValue();
            if (!map.containsKey(target - stock)) {
                continue;
            }
            if (used.contains(target - stock) || used.contains(stock)) {
                continue;
            }
            
            used.add(stock);
            used.add(target - stock);

            if (stock != target - stock) {
                ans++;
                res.add(Arrays.asList(stock, target - stock));
            } else if (count >= 2) {
                ans++;
                res.add(Arrays.asList(stock, stock));
            }
        } 

        System.out.println(res);
        return ans;
    }

    public static int test2(List<Integer> input, int target) {
        Collections.sort(input);

        int left = 0, right = input.size() - 1;
        int prevLeft = -1, prevRight = -1;

        int result = 0;
        while (left < right) {
            int temp = input.get(left) + input.get(right);
            if (temp == target) {
                if (input.get(left) != prevLeft && input.get(right) != prevRight) {
                    result++;
                    prevLeft = input.get(left);
                    prevRight = input.get(right);
                }
                left++;
                right--;
            } else if (temp > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
    
}
