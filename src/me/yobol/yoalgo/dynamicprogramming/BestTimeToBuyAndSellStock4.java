package me.yobol.yoalgo.dynamicprogramming;

public class BestTimeToBuyAndSellStock4 {

    public int getMaxProfit(int k, int[] prices) {
        int n;
        if (prices == null || (n = prices.length) <= 1) {
            return 0;
        }

        // 只需要找到最低的valley和它之后最高的peak就可以
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int day = 1; day < n; day++) {
                if (prices[day] > prices[day - 1]) {
                    maxProfit += prices[day] - prices[day - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int min = prices[0];
            for (int sellingDay = 1; sellingDay < n; sellingDay++) {
                min = Math.min(min, prices[sellingDay] - dp[i - 1][sellingDay - 1]);
                dp[i][sellingDay] = Math.max(dp[k][sellingDay - 1], prices[sellingDay] - min);
            }
        }

        return dp[k][n - 1];
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
