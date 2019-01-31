package me.yobol.yoalgo.sort.internalsort;

public class QuickSort extends Sort{

    @Override
    public void sort(int[] nums) {
        System.out.print("Execute quick sort: ");
        quickSort(nums);
    }

    private void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            if (low < high) {
                swap(nums, low, high);
                low++;
            }
            while (low <high && nums[low] <= pivot) low++;
            if (low < high) {
                swap(nums, low, high);
                high--;
            }
        }
        return low;
    }

    private void quickSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int pivotPos = partition(nums, low, high);
            quickSortHelper(nums, low, pivotPos - 1);
            quickSortHelper(nums, pivotPos + 1 ,high);
        }
    }
}
