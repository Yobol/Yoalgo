package me.yobol.yoalgo.sort.internalsort;

public class ShellSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute shell sort: ");
        shellSort(nums);
    }


    /**
     * 将待排序列在逻辑上分割成若干个形如V(i,i+d,...,i+kd)(i∈[0,d))的子序列，分别进行直接插入排序
     * 不断缩小d的值，即逐渐扩大子序列的长度，直到所有子序列”合并“为一个序列时
     * 此时，整个序列中的元素”基本有序“，再对整个序列进行一次直接插入排序。
     * @param nums
     */
    private void shellSort(int[] nums) {
        for (int gap = nums.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int cur = nums[i];

                int j;
                for (j = i; j >= gap && cur < nums[j - gap]; j -= gap) {
                    nums[j] = nums[j - gap]; // 元素后移
                }
                nums[j] = cur;
            }
        }
    }
}
