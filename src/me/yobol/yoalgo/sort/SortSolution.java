package me.yobol.yoalgo.sort;

import java.util.Arrays;

/**
 * default sorting approach is ascend
 */
public class SortSolution {

    private static int findIndexOfMinimum(int[] a, int start, int end) {
        int mixIndex = start;
        for (int i = start + 1;i < end;i++) {
            if (a[i] < a[mixIndex]) {
                mixIndex = i;
            }
        }
        return mixIndex;
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /**
     * 每次都将一个待排序的元素，按其关键字大小插入到前面已经排好序的子序列中，直到全部元素插入完成
     * @param a
     */
    private static void insertionSort(int[] a) {
        int j;

        for (int i = 1; i < a.length; i++) {
            int cur = a[i];

            for (j = i; j >= 1 && cur < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = cur;
        }
    }

    private static void binarySearchSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int cur = a[i];
            int k = Arrays.binarySearch(a, 0, i, cur);
            // 如果要查找的key不存在，则返回-(k + 1) < 0，那么k = -k - 1
            if (k < 0) {
                k = - k - 1;
            }
            for (int j = i; j > k; j--) {
                a[j] = a[j - 1];
            }
            a[k] = cur;
        }
    }

    /**
     * 每次都从待排序的元素中选出最小/大的元素，放到已排序元素的后面
     * select the smallest/biggest element from the elements to be sorted every time，and put it after the sorted elements
     */
    private static void selectionSort(int[] a) {
        for (int i = 0;i < a.length;i++) {
            int maxIndex = findIndexOfMinimum(a, i, a.length);
            if (a[i] != a[maxIndex]) {
                swap(a, i, maxIndex);
            }
        }
    }

    private static void quickSort(int[] a) {
        quickSortHelper(a, 0, a.length - 1);
    }

    private static void quickSortHelper(int[] a, int start, int end) {
        int low = start, high = end, pivot = a[start];

        while (low < high) {
            while (low < high && a[high] >= pivot) high--;
            if (low < high) {
                swap(a, low, high);
                low++;
            }
            while (low <high && a[low] <= pivot) low++;
            if (low < high) {
                swap(a, low, high);
                high--;
            }
        }
        if (low > start)
            quickSortHelper(a, start, low - 1);
        if (high < end)
            quickSortHelper(a, low + 1 ,end);

    }

    private static boolean validate(int[] a) {
        for (int i = 0;i < a.length - 1;i++) {
            if (a[i] > a[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {8, 3, 2, 5, 9, 1, 6};
        insertionSort(a);
        if (validate(a)) {
            System.out.println("error");
        } else {
            System.out.println(Arrays.toString(a));
        }

        int[] a1 = {8, 3, 2, 5, 9, 1, 6};
        binarySearchSort(a1);
        if (validate(a1)) {
            System.out.println("error");
        } else {
            System.out.println(Arrays.toString(a1));
        }

        int[] b = {1, 3, 5 , 6 , 7, 2, 8};
        selectionSort(b);
        if (validate(b)) {
            System.out.println("error");
        } else {
            System.out.println(Arrays.toString(b));
        }

        int[] c = {12, 15, 6, 7, 4};
        quickSort(c);
        if (validate(c)) {
            System.out.println("error");
        } else {
            System.out.println(Arrays.toString(c));
        }
    }
}
