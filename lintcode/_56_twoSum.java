package lintcode;

import java.util.HashMap;
import java.util.Map;

public class _56_twoSum {
    public class Solution {
        /**
         * @param numbers: An array of Integer
         * @param target:  target = numbers[index1] + numbers[index2]
         * @return: [index1, index2] (index1 < index2)
         */
        public int[] twoSum(int[] numbers, int target) {
            // write your code here
            Map<Integer, Integer> map = new HashMap<>();
            int[] ans = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(target - numbers[i])) {
                    ans[0] = map.get(target - numbers[i]);
                    ans[1] = i;
                    break;
                } else {
                    map.put(numbers[i], i);
                }
            }

            return ans;
        }
    }
    
}
