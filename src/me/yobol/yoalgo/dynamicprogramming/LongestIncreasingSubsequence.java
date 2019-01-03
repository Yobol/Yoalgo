package me.yobol.yoalgo.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * Find the length of longest increasing subsequence in a given array of integer.
     * @param nums
     * @return
     */
    public int findLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int k = 0; k < dp.length; k++) {
            System.out.print(dp[k] + " ");
        }
        System.out.println();
        // maxlen is used to save the length of LIS of the entire sequence.
        int maxlen = 1;
        for (int i = 1;i < dp.length;i++) {
            // maxval - 1 is used to represent the quantity of elements smaller than nums[i].
            // maxval represents the length of CIS that makes nums[i] as the maximum.
            int maxval = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j] + 1);
                }
            }
            dp[i] = maxval;
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }

    /**
     * Find the length of longest increasing subsequence in a given array of integer.
     * With binary search,wo can finish specific task only taking O(nlogn) time.
     * @param nums
     * @return
     */
    public int findLISWithBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int maxlen = 0;
        for (int num : nums) {
            // Arrays.binarySearch() method returns index of the search key,
            // if it is contained in the array,
            // else it returns (-(insertion point) - 1).
            int i = Arrays.binarySearch(dp, 0, maxlen, num);
            if (i < 0) {
                i = -(i + 1);
            }

            dp[i] = num;
            if (i == maxlen) {
                maxlen++;
            }

        }
        return maxlen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = new int[]{10, 9, 2, 5, 1, 7, 101, 18}; // 4
//        int[] nums = new int[]{4, 10, 4, 3, 8, 9}; // 3
//        int[] nums = new int[]{0, 8, 4, 12, 2};
        System.out.println(lis.findLISWithBinarySearch(nums));
    }
}
