package me.yobol.yoalgo.sort.internalsort;

public class HeapSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute heap sort: ");
        heapSort(nums);
    }

    private void buildMaxHeap(int[] nums) {
        for (int parent = (nums.length - 2) / 2; parent >= 0; parent--) {
            percolateDown(nums, nums.length, parent);
        }
    }

    /**
     * 向下调整的时间与树高有关，为O(logn)。
     */
    private void percolateDown(int[] nums, int lenOfUnsorted, int parent) {
        int tmp = nums[parent];
        int child;
        for (child = parent * 2 + 1; child <= lenOfUnsorted - 1; child = child * 2 + 1) {
            if (child < lenOfUnsorted - 1 && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[child] < nums[parent]) { // 子结点都比父节点小
                break;
            } else {
                swap(nums, child, parent);
                parent = child;
            }
        }
        nums[parent] = tmp;
    }

    private void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        buildMaxHeap(nums);
        // cur为当前有序序列的起始位置，也为待排序列的长度
        for (int startOfSorted = nums.length - 1; startOfSorted > 0; startOfSorted--) {
            swap(nums, startOfSorted, 0);
            percolateDown(nums, startOfSorted, 0);
        }
    }
}
