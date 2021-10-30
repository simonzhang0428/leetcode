package OA_Goldman;

import java.util.*;

public class Inversion_Decreasing {
    public static void main(String[] args) {
        int[] nums1 = { 5, 3, 4, 2, 1 };
        int[] nums2 = { 4, 2, 2, 1 };
        int[] nums3 = { 4, 1, 3, 2, 5};
        int[] nums4 = { 15, 10, 1, 7, 8};

        System.out.println("7: " + countInversions(nums1));
        System.out.println("1: " + countInversions(nums2));
        System.out.println("1: " + countInversions(nums3));
        System.out.println("3: " + countInversions(nums4));

        System.out.println("7: " + test(nums1));
        System.out.println("1: " + test(nums2));
        System.out.println("1: " + test(nums3));
        System.out.println("3: " + test(nums4));

        System.out.println("7: " + getInvCount(nums1));
        System.out.println("1: " + getInvCount(nums2));
        System.out.println("1: " + getInvCount(nums3));
        System.out.println("3: " + getInvCount(nums4));

    }

    // Binary Indexed Tree, 全选不去重
    static class Fenwick {
        int[] sum;

        public Fenwick(int n) {
            sum = new int[n];
        }

        public int query(int index) {
            int total = 0;
            while (index > 0) {
                total += sum[index];
                index -= lowBit(index);
            }
            return total;
        }

        public void update(int index, int diff) {
            while (index < sum.length) {
                sum[index] += diff;
                index += lowBit(index);
            }
        }

        public void clear() {
            Arrays.fill(sum, 0);
        }

        public int lowBit(int x) {
            return x & (-x);
        }
    }

    public static int countInversions(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = getRank(sorted);

        Fenwick tree = new Fenwick(rank.size() + 1);

        int n = arr.length;
        int[] greater = new int[n];
        int[] smaller = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            smaller[i] = tree.query(rank.get(arr[i]) - 1);
            tree.update(rank.get(arr[i]), 1);
        }

        tree.clear();

        for (int i = 0; i < n; i++) {
            greater[i] = i - tree.query(rank.get(arr[i]));
            tree.update(rank.get(arr[i]), 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += smaller[i] * greater[i];
        }
        
        return count;
    }

    private static Map<Integer, Integer> getRank(int[] sorted) {
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                map.put(sorted[i], rank++);
            }
        }
        return map;
    }

    // brute force, O(n^3)
    public static int test(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (hash.add(i)) {
                list.add(i);
            } 
        }

        // System.out.println(list);
        Integer[] arr = list.toArray(new Integer[0]);

        int res = 0, size = arr.length;
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                if (arr[i] > arr[j]) {
                    for (int k = j + 1; k < size; k++) {
                        if (arr[j] > arr[k]) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static int getInvCount(int nums[]) {
        Set<Integer> hash = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (hash.add(i)) {
                list.add(i);
            }
        }
        Integer[] arr = list.toArray(new Integer[0]);

        int n = arr.length;
        int invcount = 0; // initialize result

        for (int i = 0; i < n - 1; i++) {
            // count all smaller elements on right of arr[i]
            int small = 0;
            for (int j = i + 1; j < n; j++)
                if (arr[i] > arr[j])
                    small++;

            // count all greater elements on left of arr[i]
            int great = 0;
            for (int j = i - 1; j >= 0; j--)
                if (arr[i] < arr[j])
                    great++;

            // update inversion count by adding all inversions
            // that have arr[i] as middle of three elements
            invcount += great * small;
        }
        return invcount;
    }
}
