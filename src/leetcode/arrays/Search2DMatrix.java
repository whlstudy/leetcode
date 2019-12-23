package leetcode.arrays;

/**
 * @author whl
 * @date 2019/12/23 4:40 下午
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50}
        };
        System.out.println(new Search2DMatrix().searchMatrix(arr,10));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}
