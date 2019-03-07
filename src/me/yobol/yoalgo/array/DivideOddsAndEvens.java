package me.yobol.yoalgo.array;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 1.要想保证相对位置不变，则只能顺次移动或相邻交换；
 * 2.even从左向右遍历，找到第一个偶数；
 * 3.odd从even+1开始向后找，直到找到第一个奇数；
 * 4.将[even,...,odd-1]的元素整体后移一位，最后将找到的奇数放入even位置，然后even++；
 * 5.当odd等于数组长度时结束循环。
 */
public class DivideOddsAndEvens {

    public void reorder(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int even = 0, odd;
        while (even < nums.length) {
            while (even < nums.length && nums[even] % 2 == 1) even++;
            odd = even + 1;
            while (odd < nums.length && nums[odd] % 2 == 0) odd++;
            if (odd == nums.length) {
                return;
            } else {
                int tmp = nums[odd];
                for (int i = odd - 1; i >= even; i--) {
                    nums[i + 1] = nums[i];
                }
                nums[even++] = tmp;
            }
        }

    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        DivideOddsAndEvens s = new DivideOddsAndEvens();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        s.reorder(nums);
        System.out.println(Arrays.toString(nums));
    }
}
