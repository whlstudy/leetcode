package leetcode.dynamic;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 */
public class EditDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row + 1][col + 1];

        // 初始化
        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= col; i++) {
            dp[0][i] = i;
        }
        int d;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    d = 0;
                } else{
                    d = 1;
                }

                dp[i][j] = Math.min(dp[i - 1][j - 1] + d, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }

        return dp[row][col];
    }
}
