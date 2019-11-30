package leetcode.dynamic;

/**
 * @author whl
 * @date 2019/10/15 3:48 下午
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell
 * one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 *  该题的本质是找数组中二个数字的最大顺序差
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,0,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int maxCur = 0;
        int maxSofar = 0;
        for(int i = 1;i < prices.length;i++){
            maxCur = Math.max(0,maxCur += prices[i] - prices[i-1]);
            maxSofar = Math.max(maxCur,maxSofar);
        }
        return maxSofar;
    }
}
