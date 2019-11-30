package leetcode.tree;

/**
 * @author whl
 * @date 2019/10/18 6:45 下午
 */
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        return dfs(arr, 0, arr.length - 1, dp);
    }

    public int dfs(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int temp = i; temp < j; temp++) {
            int left = dfs(arr, i, temp, dp);
            int right = dfs(arr, temp + 1, j, dp);
            int maxL = 0;
            int maxR = 0;
            for (int t = i; t <= temp; t++) maxL = Math.max(maxL, arr[t]);
            for (int t = temp + 1; t <= j; t++) maxR = Math.max(maxR, arr[t]);
            ans = Math.min(ans, left + right + maxL * maxR);
        }
        dp[i][j] = ans;
        return ans;
    }
}
