package LeetCode;

/**
 * Created by allen on 6/6/15.
 */


/**
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:
 * 1) Integers in each row are sorted from left to right. 2) The first integer of each row is greater than the last integer of the previous row.
 *
 */

/**
 *
 * You may try to solve this problem by finding the row first and then the column. There is no need to do that. Because of the matrix's special features, the matrix can be considered as a sorted array. Your goal is to find one element in this sorted array by using binary search.
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midX = mid / cols;
            int midY = mid % cols;
            if (matrix[midX][midY] == target) return true;
            if (matrix[midX][midY] > target) end = mid - 1;
            if (matrix[midX][midY] < target) start = mid + 1;
        }
        return false;
    }


    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(search2DMatrix.searchMatrix(matrix, 3));
    }


}
