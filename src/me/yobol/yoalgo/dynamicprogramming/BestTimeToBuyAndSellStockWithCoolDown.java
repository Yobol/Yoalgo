package me.yobol.yoalgo.dynamicprogramming;

public class BestTimeToBuyAndSellStockWithCoolDown {

    public int getMaxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int day = 0;
        int[] rest = new int[prices.length];
        int[] buy = new int[prices.length];
        buy[0] = -prices[day];
        int[] sell = new int[prices.length];
        sell[0] = Integer.MIN_VALUE;
        for (day = 1; day < prices.length; day++) {
            rest[day] = Math.max(rest[day - 1], sell[day - 1]);
            buy[day] = Math.max(buy[day - 1], rest[day - 1] - prices[day]);
            sell[day] = buy[day - 1] + prices[day];
            System.out.println(rest[day] + " : " + buy[day] + " : " + sell[day]);
        }
        return Math.max(rest[prices.length - 1], sell[prices.length - 1]);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCoolDown bestTimeToBuyAndSellStockWithCoolDown = new BestTimeToBuyAndSellStockWithCoolDown();
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(bestTimeToBuyAndSellStockWithCoolDown.getMaxProfit(prices));
    }
}
