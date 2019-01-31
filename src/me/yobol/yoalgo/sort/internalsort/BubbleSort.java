package me.yobol.yoalgo.sort.internalsort;

public class BubbleSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute bubble sort: ");
        bubbleSort(nums);
    }

    /**
     * 假设待排序表长为n，从后往前两两比较相邻元素的值，
     * 若为逆序（前面的比后面的大），则交换它们的位置，
     * 直到序列比较完（比较n-1次），称为一次“冒泡”，其结果为将待排序列中的最小元素交换到最前面。
     *
     * 下一次“冒泡”时，前一次“冒泡”确定的最小元素不再参与比较，即待排序列减少一个元素，
     *
     * 每次“冒泡”的结果都必将序列中的最小元素交换到序列的最终位置。
     * 至多做n-1次排序，就能将所有元素排好序。
     */
    private void bubbleSort(int[] nums) {
        boolean isSorted;
        for (int lenOfSortedSubSequence = 1; lenOfSortedSubSequence < nums.length; lenOfSortedSubSequence++) {
            isSorted = true;
            for (int posOfCurrentBubble = nums.length - 1; posOfCurrentBubble >= lenOfSortedSubSequence; posOfCurrentBubble--) {
                if (nums[posOfCurrentBubble] < nums[posOfCurrentBubble - 1]) {
                    swap(nums, posOfCurrentBubble, posOfCurrentBubble - 1);
                    isSorted = false;
                }
            }
            if (isSorted) { // 不一定要进行n - 1躺冒泡，且每次不一定要遍历整个序列
                return; // 本躺遍历后没有发生交换，说明序列已经有序
            }
        }
    }
}
