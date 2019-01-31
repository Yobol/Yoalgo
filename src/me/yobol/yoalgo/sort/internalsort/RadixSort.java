package me.yobol.yoalgo.sort.internalsort;

public class RadixSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute radix sort: ");
        radixSort(nums, 10);
    }

    private int getMaxDigit(int[] nums) {
        int maxDigit = 0;
        for (int num : nums) {
            int digit = 0;
            while (num != 0) {
                num /= 10;
                digit++;
            }
            maxDigit = Math.max(maxDigit, digit);
        }
        return maxDigit;
    }

    private void radixSort(int[] nums, int radix) {
        int maxDigit = getMaxDigit(nums);
        int[][] buckets = new int[radix][nums.length];
        int[] counters = new int[radix]; // counters[i]表示该位是i的数的个数
        for (int digit = 0, k = 0; digit < maxDigit; digit++, k = 0) {
            int nRadix = (int)Math.pow(radix, digit);
            // allocating
            for (int num : nums) {
                int i = (num / nRadix) % radix;
                buckets[i][counters[i]] = num;
                counters[i]++;
            }
            // collecting
            for (int i = 0; i < radix; i++) {
                if (counters[i] != 0) {
                    for (int j = 0; j < counters[i]; j++) {
                        nums[k] = buckets[i][j];
                        k++;
                    }
                }
                counters[i] = 0;
            }
        }
    }
}
