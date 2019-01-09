package me.yobol.yoalgo.dynamicprogramming;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;

        int maxEndingHere = nums[0];
        int maxSoFar = maxEndingHere;
        for (int i = 1; i < len; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return  maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubArray maximumSubarray = new MaximumSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSubarray.maxSubArray(nums));
    }
}
