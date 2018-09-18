package me.yobol.yoalgo.array;

/**
 *  Description:
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *  Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */
public class TwoSum {

    private int[] twoSum(int[] nums,int target){
        for (int i = 0;i < nums.length - 1;i++){
            for (int j = i + 1;j < nums.length;j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args){
        int[] givens = {2, 7, 11, 15};
        int target = 9;
        int[] res = new TwoSum().twoSum(givens, target);
        System.out.println("[" + res[0] + "," + res[1] + "]");
    }
}
