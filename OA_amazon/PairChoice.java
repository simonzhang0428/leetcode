package OA_amazon;

import java.util.*;

// input: deviceCapacity = 7, foregroundAppList = [[1,2],[2,4],[3,6]], backgroundAppList = [[1,2]]  数组里的第一个数算是index，第二个是value
// output: 从f 和 b里面选出value和不超过deviceCapacity，尽量接近deviceCapacity 的组合的index， 上面的例子的结果是 [1,2]。
// 题不难，就是要注意是要求出所有组合，比如：
// input: deviceCapacity=30, foregroundAppList = [[1,11],[2,11],[3,11]], backgroundAppList = [[1,9],[2,9]]
// 返回的值是 [[1,1],[2,1],[3,1],[1,2],[2,2],[3,2]]
public class PairChoice {
    public static List<List<Integer>> getPair(int[][] a, int[][] b, int target) {
        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        Arrays.sort(b, (x, y) -> x[1] - y[1]);
        List<List<Integer>> res = new ArrayList<>();
        int max = -1;
        int aInd = 0;
        int bInd = b.length - 1;
        
        while (aInd < a.length && bInd >= 0) {
            int aVal = a[aInd][1];
            int bVal = b[bInd][1];
            int sum = aVal + bVal;

            if (sum > target) {
                bInd--;
            } else {
                if (sum >= max) {
                    if (sum > max) {
                        res.clear(); // only keep the largest sum
                        max = sum;
                    }
                    res.add(Arrays.asList(a[aInd][0], b[bInd][0]));

                    int index = bInd - 1;
                    // fixed a, if b has the same value, keep adding to the result
                    while (index >= 0 && b[index][1] == b[index + 1][1]) {
                        res.add(Arrays.asList(a[aInd][0], b[index][0]));
                        index--;
                    }
                }
                aInd++;
            }
        }
        
        return res;
    }

    public static void main(String...s) {
        int[][][] As = {
            {{1, 2}, {2, 4}, {3, 6}},
            {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
            {{1, 8}, {2, 7}, {3, 14}},
            {{1, 8}, {2, 15}, {3, 9}}
        };
        int[][][] Bs = {
            {{1, 2}},
            {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
            {{1, 5}, {2, 10}, {3, 14}},
            {{1, 8}, {2, 11}, {3, 12}}
        };
        int[] targets = {7, 10, 20, 20};

        for (int i=0; i < 4; i++) {
            System.out.println(getPair(As[i], Bs[i], targets[i]).toString());
        }
    }
}
