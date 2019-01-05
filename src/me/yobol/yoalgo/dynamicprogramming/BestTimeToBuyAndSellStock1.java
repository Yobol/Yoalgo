package me.yobol.yoalgo.dynamicprogramming;

public class BestTimeToBuyAndSellStock1 {

    public int getMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int day = 0;day < prices.length;day++) {
            if (prices[day] < minPrice) {
                minPrice = prices[day];
            } else if (prices[day] - minPrice > maxProfit) {
                maxProfit = prices[day] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock1 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock1();
        int[] prices = new int[] {7, 1, 5, 3, 6, 4}; // 5
//        int[] prices = new int[] {7, 6, 5, 4, 3}; // 0
        System.out.println(bestTimeToBuyAndSellStock.getMaxProfit(prices));
    }
}
