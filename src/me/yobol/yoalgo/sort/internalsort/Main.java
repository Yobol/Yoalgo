package me.yobol.yoalgo.sort.internalsort;

public class Main {


    public static void main(String[] args) {

        Sort sort;
        int[] a = {8, 3, 2, 5, 9, 1, 6};

        sort = new InsertionSort();
        sort.validate(a);

        sort = new BinarySearchSort();
        sort.validate(a);

        sort = new ShellSort();
        sort.validate(a);

        sort = new BubbleSort();
        sort.validate(a);

        sort = new QuickSort();
        sort.validate(a);

        sort = new SelectionSort();
        sort.validate(a);

        sort = new HeapSort();
        sort.validate(a);

        sort = new MergeSort();
        sort.validate(a);

        sort = new RadixSort();
        sort.validate(a);

        sort = new CountSort();
        sort.validate(a);
    }
}
