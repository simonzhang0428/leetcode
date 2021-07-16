public class quickSort {
    Random random = new Random();
    public int[] sortIntegers(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        helper(arr, 0, arr.length - 1);
        return arr;  
    }

    private void helper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(arr, randomIndex, right);
        int pivotIndex = partition(arr, left, right);
        helper(arr, left, pivotIndex - 1);
        helper(arr, pivotIndex + 1, right);
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int left, int right) {
        int i = left, j = right - 1;
        while (i <= j) {
            if (arr[i] < arr[right]) {
                i++;
            } else {
                swap(arr, i, j);
                j--;
            }
        }
        swap(arr, i, right);
        return i;
    }
}
