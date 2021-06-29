import java.util.Arrays;

/*
240. Search a 2D Matrix II
Medium	4963/93

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

C	input:	int[][] matrix, int target
	output:	boolean true/false
A	restrict ascending order, not duplicate in the matrix, m(row) >= 1, n(col) >= 1
R	start from left-bottom, compare with target, 
if target is bigger, col++, 
if target is smaller, row--, 
until out of bound, not found
*/
class SearchMatrix240 {

	public static boolean searchMatrix(int[ ][ ] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int i = m - 1, j = 0;
		while (i >= 0 && j < n) {
			if (matrix[i][j] == target) 	return true;
			else if (matrix[i][j] < target) 	j++;
			else i--;
		}
		return false;
	}
	public static void main(String[ ] args) {
		int[][] matrix = { {1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22}};
		System.out.println(searchMatrix2(matrix, 16));
	}

	// binary search: diagonal??
	// bs first row, find left, go down 
	// bs the col, find left, 
	// 			L		R
	// 1	3	5	10		20	target = 16
	// 2	6	8	13	L	22
	// 4	15	16	17	R	25	
	// L			R

	//  binary search each row, until last row, O(M * logN)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
			if (matrix[i][0] == target || matrix[i][n - 1] == target)	return true;
			if (matrix[i][0] > target || matrix[i][n - 1] < target)	continue;
            if (Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
        }

        return false;
    }
}