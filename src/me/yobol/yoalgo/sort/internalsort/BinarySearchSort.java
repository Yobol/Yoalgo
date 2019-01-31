package me.yobol.yoalgo.sort.internalsort;

import java.util.Arrays;

public class BinarySearchSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute binary search sort: ");
        binarySearchSort(nums);
    }

    /**
     *
     * 1. 先用二分查找法找出元素的插入位置k；
     * 2. 再统一将待插入位置及之后的所有元素后移一个位置；
     * 3. 将V(i)赋值给V(k)。
     */
    private void binarySearchSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int k = Arrays.binarySearch(nums, 0, i, cur);
            // 如果要查找的key不存在，则返回-(k + 1) < 0，那么k = -k - 1
            if (k < 0) {
                k = -k - 1;
            }
            for (int j = i; j > k; j--) {
                nums[j] = nums[j - 1];
            }
            nums[k] = cur;
        }
    }
}
