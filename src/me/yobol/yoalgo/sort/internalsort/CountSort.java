package me.yobol.yoalgo.sort.internalsort;

public class CountSort extends Sort {

    @Override
    protected void sort(int[] nums) {
        System.out.print("Execute count sort: ");
        countSort(nums);
    }

    private void countSort(int[] nums) {
        int[] tmp = nums.clone();
        for (int num : tmp) {
            int cntOfLesThanNum = 0;
            int cntOfEquWithNum = 0;
            for (int cur : tmp) {
                if (cur < num) {
                    cntOfLesThanNum++;
                } else if (cur == num) {
                    cntOfEquWithNum++;
                }
            }

            for (int i = cntOfLesThanNum; i < cntOfLesThanNum + cntOfEquWithNum; i++) {
                nums[i] = num;
            }
        }
    }
}
