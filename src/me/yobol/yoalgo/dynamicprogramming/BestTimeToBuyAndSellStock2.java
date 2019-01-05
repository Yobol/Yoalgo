package me.yobol.yoalgo.dynamicprogramming;

public class BestTimeToBuyAndSellStock2 {

    public int getMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        for (int day = 1;day < prices.length;day++) {
            if (prices[day] > prices[day - 1]) {
                maxProfit += prices[day] - prices[day - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();
        int[] prices = new int[]{1, 7, 2, 3, 6, 7, 6, 7};
        System.out.println(bestTimeToBuyAndSellStock.getMaxProfit(prices));
    }
}
