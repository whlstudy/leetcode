package leetcode.dynamic;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 */
public class DivisorGame {

    public static void main(String[] args){
        System.out.println(minCostClimbingStairs(new int[]{10,15,23}));
    }

    /**
     * 贪心算法
     */
    public static int minCostClimbingStairs(int[] cost){
        if(cost.length <= 1) return 0;
        if(cost.length == 2) return Math.max(cost[0],cost[1]);
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2;i < cost.length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        dp[dp.length-1] = Math.min(dp[dp.length-2],dp[dp.length-3]);// 最后一步
        return dp[dp.length-1];
    }
}
