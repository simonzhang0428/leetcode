import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start

class Solution {
    // double pivot quick sort
    public int[] sortArray(int[] nums) {
        dualPivotQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void dualPivotQuickSort(int[] arr, int start, int end) {
        if (start > end)
            return;// 参数不对直接返回
        if (arr[start] > arr[end])
            swap(arr, start, end);
        int pivot1 = arr[start], pivot2 = arr[end];// 储存最左侧和最右侧的值
        // (start，left]:左侧小于等于pivot1 [right,end)大于pivot2
        int left = start, right = end, k = left + 1;
        while (k < right) {
            // 和左侧交换
            if (arr[k] <= pivot1) {
                // 需要交换
                swap(arr, ++left, k++);
            } else if (arr[k] <= pivot2) {// 在中间的情况
                k++;
            } else {
                while (arr[right] >= pivot2) {// 如果全部小于直接跳出外层循环

                    if (right-- == k)
                        break;
                }
                if (k >= right)
                    break;
                swap(arr, k, right);
            }
        }
        swap(arr, start, left);
        swap(arr, end, right);
        dualPivotQuickSort(arr, start, left - 1);
        dualPivotQuickSort(arr, left + 1, right - 1);
        dualPivotQuickSort(arr, right + 1, end);
    }

    void swap(int arr[], int i, int j) {
        int team = arr[i];
        arr[i] = arr[j];
        arr[j] = team;
    }
}
// @lc code=end

