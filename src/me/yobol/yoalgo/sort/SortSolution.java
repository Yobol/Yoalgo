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
     * 每次都从待排序的元素中选出最小/大的元素，放到已排序元素的后面
     * select the smallest/biggest element from the elements to be sorted every time，and put it after the sorted elements
     * @param a
     * @return
     */
    public static int[] selectionSort(int[] a) {
        for (int i = 0;i < a.length;i++) {
            int maxIndex = findIndexOfMinimum(a, i, a.length);
            if (a[i] != a[maxIndex]) {
                swap(a, i, maxIndex);
            }
        }
        return a;
    }

    public static boolean validate(int[] a) {
        for (int i = 0;i < a.length - 1;i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5 , 6 , 7, 2, 8};
        selectionSort(a);
        if (!validate(a)) {
            System.out.println("error");
        } else {
            System.out.println(Arrays.toString(a));
        }
    }
}
