import java.util.*;

public class _215 {
    public int findKthLargest1(int[] nums, int k) {
        // time: O(n + klogn)   
        // space: O(n)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            maxHeap.offer(i);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        // time:    O(k + (n-k)logk)
        // space:   O(k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.poll();
    }


    // quick partition
    // average time: O(n)
    // worst time: O(n^2)
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = k - 1;
        helper(nums, 0, nums.length - 1, targetIndex);
        return nums[targetIndex];
    }
    private void helper(int[] nums, int left, int right, int targetIndex) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        if (pivot == targetIndex) {
            return;
        } else if (pivot > targetIndex) {
            helper(nums, left, pivot - 1, targetIndex);
        } else {
            helper(nums, pivot + 1, right, targetIndex);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int partition(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, randomIndex, right);
        int i = left, j = right - 1;
        while (i <= j) {
            if (nums[i] > nums[right]) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, right);
        return i;
    }

}