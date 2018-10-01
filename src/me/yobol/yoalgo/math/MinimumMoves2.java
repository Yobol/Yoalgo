package me.yobol.yoalgo.math;

import java.util.Arrays;

/**
 * Description
 * Given a non-empty integer array,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3] => [2,2,3] => [2,2,2]
 */
public class MinimumMoves2 {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int target;
        if (nums.length % 2 == 1) {
            target = nums[nums.length / 2];
        } else {
            int m1 = nums[nums.length / 2 - 1], m2 = nums[nums.length / 2];
            float median = (m1 + m2) / 2;
            target = Math.abs(m1 - median) < Math.abs(m2 - median) ? m1 : m2;
        }
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                moves += Math.abs(nums[i] - target);
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        MinimumMoves2 mm = new MinimumMoves2();
        System.out.println(mm.minMoves(new int[]{3, 2, 3, 8}));
    }
}
