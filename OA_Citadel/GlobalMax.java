package OA_Citadel;

import java.util.*;

public class GlobalMax {

    // public static int findMaximum(List<Integer> arr, int m) {
    //     int n = arr.size(); // size of the list
    //     int guess = (arr.get(n - 1) - arr.get(0)) / (m - 1); // this is maxGap possible
    //     // we are trying to find the optimal sequence for which min-gap will be maximum
    //     while (true) {
    //         int i = 1; // current index
    //         int c = 1; // elements alloted in the sequence
    //         int prev = arr.get(0); // will store the last value of the sequence
    //         while (i != n) {
    //             if (arr.get(i) - prev >= guess) { // if adequate gap is found
    //                 c++; // increment the number of elements in sequence
    //                 prev = arr.get(i); // update the last value
    //             }
    //             i++;
    //         }
    //         if (c >= m) // if m elements were found maintaining the guess gap
    //             return guess;
    //         guess--; // if not decrement the gap by 1
    //     }
    // }

    // public static void main(String[] args) {
    //     // for testing
    //     List<Integer> arr = new ArrayList<Integer>();
    //     arr.add(1);
    //     arr.add(2);
    //     arr.add(3);
    //     arr.add(4);
    //     int m = 2;
    //     System.out.println(findMaximum(arr, m)); // will print 3
    // }

    // Function to check a subsequence can
    // be formed with min difference mid
    static boolean can_place(int A[], int n, int B, int mid) {
        int count = 1;
        int last_position = A[0];

        // If a subsequence of size B
        // with min diff = mid is possible
        // return true else false
        for (int i = 1; i < n; i++) {
            if (A[i] - last_position >= mid) {
                last_position = A[i];
                count++;
                if (count == B) {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to find the maximum of
    // all minimum difference of pairs
    // possible among the subsequence
    static int find_min_difference(int A[], int n, int B) {

        // Sort the Array
        Arrays.sort(A);

        // Stores the boundaries
        // of the search space
        int s = 0;
        int e = A[n - 1] - A[0];

        // Store the answer
        int ans = 0;

        // Binary Search
        while (s <= e) {
            int mid = (s + e) / 2;

            // If subsequence can be formed
            // with min diff mid and size B
            if (can_place(A, n, B, mid)) {
                ans = mid;

                // Right half
                s = mid + 1;
            } else {

                // Left half
                e = mid - 1;
            }
        }
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] A= { 1, 2, 3, 5 };
        int n = A.length;
        int B = 3;

        int min_difference = find_min_difference(A, n, B);

        System.out.println("2: " + min_difference);
    }
}