package me.yobol.yoalgo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Given an array of integers that is [[already sorted in ascending order]], find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumSortedArray {
    private int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] + numbers[0] > target) {
                return null;
            }
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    private int[] twoSum2(int[] numbers, int target){
        int[] indices = new int[2];
        int left = 0,right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                indices[0] = left + 1;
                indices[1] = right + 1;
                break;
            }else if (sum < target){
                left++;
            }else{
                right--;
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] givens = {2, 7, 11, 15};
        int target = 9;
        int[] res = new TwoSumSortedArray().twoSum2(givens, target);
        System.out.println("[" + res[0] + "," + res[1] + "]");
    }
}
