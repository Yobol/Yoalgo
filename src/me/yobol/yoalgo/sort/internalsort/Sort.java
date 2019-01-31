package me.yobol.yoalgo.sort.internalsort;

import java.util.Arrays;

/**
 * default sorting approach is ascend
 */
public abstract class Sort {

    protected abstract void sort(int[] nums);

    protected void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void validate(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);

        sort(temp);

        for (int i = 0;i < temp.length - 1;i++) {
            if (temp[i] > temp[i + 1]) {
                System.out.println("Fail to sort.");
                break;
            }
        }
        System.out.println(Arrays.toString(temp));

    }
}
