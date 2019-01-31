package me.yobol.yoalgo.sort.internalsort;

public class SelectionSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute selection sort: ");
        selectionSort(nums);
    }

    private int findIndexOfMinimum(int[] nums, int start, int end) {
        int minIndex = start;
        for (int i = start + 1;i < end;i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 每次都从待排序的元素中选出最小/大的元素，放到已排序元素的后面
     * select the smallest/biggest element from the elements to be sorted every time，and put it after the sorted elements
     */
    private void selectionSort(int[] nums) {
        for (int lenOfSortedSubSequence = 0;lenOfSortedSubSequence < nums.length - 1;lenOfSortedSubSequence++) {
            int minIndex = findIndexOfMinimum(nums, lenOfSortedSubSequence, nums.length);
            if (nums[lenOfSortedSubSequence] != nums[minIndex]) {
                swap(nums, lenOfSortedSubSequence, minIndex);
            }
        }
    }
}
