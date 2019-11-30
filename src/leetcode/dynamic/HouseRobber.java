package leetcode.dynamic;

/**
 * @author whl
 * @date 2019/10/22 1:44 下午
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 *
 * 房屋偷窃，不能连续偷盗二家，求最大能偷多少钱
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            if(i == 0) dp[0] = nums[0];
            else if(i == 1) dp[1] = Math.max(nums[1],dp[i-1]);
            else{
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
        }
        return dp[nums.length-1];
    }
}
