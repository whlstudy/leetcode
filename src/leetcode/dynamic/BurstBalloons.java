package leetcode.dynamic;

/**
 * @author whl
 * @date 2019/12/3 9:39 上午
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
 * coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 */
public class BurstBalloons {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{
                3, 1, 5, 8
        }));
    }

    public static int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] temp = new int[len];
        int[][] dp = new int[len][len];
        System.arraycopy(nums, 0, temp, 1, nums.length);
        temp[0] = 1;
        temp[len - 1] = 1;
        for (int i = 3; i <= len; i++) {
            for (int begin = 0; begin <= len - i; begin++) {
                int end = begin + i - 1;
                for (int l = begin + 1; l < end; l++) {
                    dp[begin][end] = Math.max(dp[begin][end], dp[begin][l] + dp[l][end] + temp[begin] * temp[end] * temp[l]);
                }
            }
        }
        return dp[0][len-1];
    }
}
