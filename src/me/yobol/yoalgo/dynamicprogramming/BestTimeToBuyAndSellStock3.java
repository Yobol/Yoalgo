package me.yobol.yoalgo.dynamicprogramming;

public class BestTimeToBuyAndSellStock3 {

    public int getMaxProfit(int[] prices) {
        // the maximal times of transaction
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int day = 0; day < prices.length; day++) {
            buy1 = Math.min(buy1, prices[day]);
            sell1 = Math.max(sell1, prices[day] - buy1);
            buy2 = Math.min(buy2, prices[day] - sell1);
            sell2 = Math.max(sell2, prices[day] - buy2);
        }

        return sell2;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock3();
//        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4}; // 6
//        int[] prices = new int[]{1, 2, 3, 4, 5}; // 4
//        int [] prices = new int[]{7, 6, 5, 4, 3, 2, 1}; // 0
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}; // 13
        System.out.println(bestTimeToBuyAndSellStock.getMaxProfit(prices));

    }
}
