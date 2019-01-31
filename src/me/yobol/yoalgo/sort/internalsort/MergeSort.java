package me.yobol.yoalgo.sort.internalsort;

public class MergeSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute merge sort: ");
        mergeSort(nums);
    }

    /**
     * 将两个有序序列组合成一个新的有序序：
     * 1. 每次取出两个序列中较小的元素输出；
     * 2. 当其中一个序列全部输出后，则输出另一序列的剩余部分。
     */
    private void merge(int[] nums, int size, int startOfA,int startOfB, int step) {
        int lenOfA = step;
        int lenOfB = startOfB + step >= size ? size - startOfB : step;
        int[] tmp = new int[lenOfA + lenOfB];
        int i = 0, j = 0;
        while (i < lenOfA && j < lenOfB) {
            if (nums[startOfA + i] <= nums[startOfB + j]) {
                tmp[i + j] = nums[startOfA + i];
                i++;
            } else {
                tmp[i + j] = nums[startOfB + j];
                j++;
            }
        }
        // 序列a中还有元素，且全部比序列b中的元素大
        while (i < lenOfA) {
            tmp[i + j] = nums[startOfA + i];
            i++;
        }
        // 序列b中还有元素，且全部比序列a中的元素大
        while (j < lenOfB) {
            tmp[i + j] = nums[startOfB + j];
            j++;
        }
        for (int k = 0; k < lenOfA + lenOfB; k++) {
            nums[startOfA + k] = tmp[k];
        }
    }

    private void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int step = 1; step < nums.length; step *= 2) {
            for (int i = 0; i < nums.length - step; i += step * 2) {
                merge(nums, nums.length, i, i + step, step);
            }
        }
    }
}
