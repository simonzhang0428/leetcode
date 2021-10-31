/*
 * @lc app=leetcode.cn id=862 lang=java
 *
 * [862] 和至少为 K 的最短子数组
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] A, int K) {
        long[] arr = new long[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            arr[i + 1] = arr[i] + A[i];
            if (A[i] >= K)
                return 1;
        }//得到前缀和数组
        
        int res = Integer.MAX_VALUE;
        // for (int i = 0; i <= A.length - 1; i++) { // 暴力破解 N^2 超时
        //     for (int j = i + 1; j <= A.length; j++) {
        //         if (arr[j] - arr[i] >= K) {
        //             res = Math.min(j - i, res);
        //         }
        //     }
        // }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[i] <= arr[queue.getLast()])
                queue.removeLast();
            while (!queue.isEmpty() && arr[i] - arr[queue.peek()] >= K)
                res = Math.min(res, i - queue.poll());
            queue.add(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

// @lc code=end

