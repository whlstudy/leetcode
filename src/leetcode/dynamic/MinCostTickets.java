package leetcode.dynamic;

public class MinCostTickets {
    public static void main(String[] args) {
        int[] days = new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = new int[]{3,13,45};
        System.out.println(mincostTickets1(days, costs));
    }

    // TODO 补充使用dfs的做法

    // dp 创建一个大小为days[days.length-1]]大小的数组
    public static int mincostTickets1(int[] days, int[] costs){
        if(days.length == 1) return costs[0];
        int[] dp = new int[days[days.length-1]+1];
        int i,j;
        dp[days[0]] = threeMin(costs[0],costs[1],costs[2]);
        for( i =1;i < days.length;i++){
            for(j = days[i-1]+1;j<days[i];j++){
                dp[j] = dp[days[i-1]];
            }
            dp[j] = threeMin(dp[j-1]+costs[0],j >= 7?(dp[j-7]+costs[1]):costs[1],j>=30?(dp[j-30]+costs[2]):costs[2]);
        }
        return dp[days[days.length-1]];
    }

    private static int threeMin(int cost, int cost1, int cost2) {
        return Math.min(cost, Math.min(cost1, cost2));
    }
}
