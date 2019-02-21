package me.yobol.yoalgo.array;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 2) return 0;

        int i = 0, j = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int l = 0, r = n - 1; r >= 0; l++, r--) {
            if (nums[l] >= max) {
                max = nums[l];
            } else {
                j = l;
            }

            if (nums[r] <= min) {
                min = nums[r];
            } else {
                i = r;
            }
        }

        return j - i + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();
        int[] nums = new int[]{7, 5, 3, 4, 2, 6, 7};
        System.out.println(sucs.findUnsortedSubarray(nums));
    }
}
