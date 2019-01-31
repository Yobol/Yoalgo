package me.yobol.yoalgo.sort.internalsort;

public class InsertionSort extends Sort {

    @Override
    public void sort(int[] nums) {
        System.out.print("Execute insertion sort: ");
        insertionSort(nums);
    }

    /**
     * 每次都将一个待排序的元素，按其关键字大小插入到前面已经排好序的子序列中，直到全部元素插入完成
     * @param nums
     */
    private void insertionSort(int[] nums) {
        int j;

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            for (j = i; j >= 1 && cur < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = cur;
        }
    }
}
