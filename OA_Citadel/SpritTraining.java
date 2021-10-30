package OA_Citadel;

import java.util.*;

public class SpritTraining {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(9, 7, 3, 1));
        System.out.println("3: " + test(input, 9));

        // input.clear();
        // input = Arrays.asList(1, 5);
        // System.out.println("1: " + test(input, 5));

        // input.clear();
        // input = Arrays.asList(9, 7, 3, 1);
        // System.out.println("3: " + test(input, 9));
    }

    public static int test(List<Integer> sprints, int n) {
        int[] arr = new int[n+2]; //array for storing total times a position is visited.initialised with 0.
        for (int i = 0; i < sprints.size() - 1; i++) {
            int a = sprints.get(i); //storing ith value in a
            int b = sprints.get(i+1); //storing i+1 th value in b 
            
            //increasing the count of smaller position by 1 and decreasing the count of (larger position+1) by 1
            if (a > b) {
                arr[b]++;
                arr[a+1]--;
            } else {
                arr[a]++;
                arr[b+1]--;
            }
        }
        
        for(int i = 1; i <= n; i++) {
            arr[i] = arr[i] + arr[i-1]; //prefix sum
        }
        
        int mx = 0, ans = 1; //max stores the max visited value and ans stores the max visited position
        for(int i = 1; i <= n; i++) {
            if (arr[i] > mx) {
                mx = arr[i]; 
                ans = i;  
            } //checking the position with larger value
        }
        return ans; //return the max visited position
    }
    
}
