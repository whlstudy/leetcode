package leetcode.dynamic;


public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {-80,-13,22},{83,94,-5},{73,-48,61}
        };
        System.out.println(minFallingPathSum(A));
    }

    // 可以使用二个数组代替，优化空间复杂度
    public static int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) dp[i][j] = A[i][j];
                else {
                    int left = Integer.MAX_VALUE;
                    int mid = Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;
                    if (j - 1 >= 0) left = dp[i - 1][j - 1];
                    mid = dp[i - 1][j];
                    if (j + 1 < col) right = dp[i - 1][j + 1];

                    dp[i][j] =A[i][j] + Math.min(left, Math.min(mid, right));

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            if (min > dp[row-1][i]) {
                min = dp[row-1][i];
            }
        }
        return min;
    }
}
