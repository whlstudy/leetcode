package leetcode.dynamic;

/**
 * @author whl
 * @date 2019/10/13 5:07 下午
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }

    // 维护三个变量当前买的最大收益buy，当前休息的最大收益cool，当前卖的最大收益sell。
    // 每一轮都是卖的收益最大
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int buy = -prices[0];
        int sell = 0;
        int cool = 0;
        for(int i = 1;i < prices.length;i++){
            buy = Math.max(buy,cool - prices[i]);
            cool = Math.max(cool,sell);
            sell = Math.max(buy + prices[i],sell);
        }
        return sell;
    }
}
