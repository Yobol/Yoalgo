package me.yobol.yoalgo.dynamicprogramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int getMaxProfit(int[] prices, int fee) {
        int maxProfit = 0;
        int day = 0;
        int minPrice = prices[day];
        for (day = 1; day < prices.length; day++) {
            if (prices[day] < minPrice) {
                minPrice = prices[day];
            } else if (prices[day] > minPrice + fee) {
                maxProfit += prices[day] - minPrice - fee;
                minPrice = prices[day] - fee;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee bestTimeToBuyAndSellStockWithTransactionFee = new BestTimeToBuyAndSellStockWithTransactionFee();
//        int[] prices = new int[]{1, 7, 2, 3, 6, 7, 6, 7}; // when fee = 2, max profit is 7.
//        int[] prices = new int[]{1, 3, 2, 8, 4, 9}; //  when fee = 2, max profit is 8.
        int[] prices = new int[]{1, 3, 7, 5, 10, 3}; // when fee = 3, max profit is 6
        System.out.println(bestTimeToBuyAndSellStockWithTransactionFee.getMaxProfit(prices, 3));
    }
}
