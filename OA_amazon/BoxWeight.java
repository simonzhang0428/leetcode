package OA_amazon;
import java.util.*;

public class BoxWeight {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 3, 1, 10, 20};
        int[] res = optimizingBoxWeight(nums);
        
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    
    public static int[] optimizingBoxWeight(int[] nums) {
        int sum = 0, right = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (right > sum - right) {
                int[] res = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    res[j] = list.get(j);
                } 
                Arrays.sort(res);
                return res;
            }
            right += nums[i];
            list.add(nums[i]);
        }
        return new int[0];
    }
}