package me.yobol.yoalgo.binarysearch;

/**
 * Description
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Example 1:
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * Input: [0,2,1,0]
 * Output: 1
 *
 * Note:
 * 1. 3 <= A.length <= 10000
 * 2. 0 <= A[i] <= 10^6
 * 3. A is a mountain, as defined above.
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int low = 1, high = A.length - 2;
        int peak;
        while (low <= high) {
            peak = (low + high) / 2;
            if (A[peak - 1] < A[peak] && A[peak] > A[peak + 1]) {
                return peak;
            } else if (A[peak - 1] > A[peak]) {
                high = peak - 1;
            } else { // A[peak] < A[peak + 1]
                low = peak + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
        int[] A = {0, 1, 0}; // 1
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(A));
        int[] B = {0, 2, 1, 0}; // 1
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(B));
        int[] C = {0, 4, 3, 2, 1, 0}; // 1
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(C));
        int[] D = {0, 1, 2, 3, 4, 0}; // 4
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(D));
        int[] E = {5, 4, 3, 2, 1, 0}; // 5
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(E));
        int[] F = {0, 1, 2, 3, 4, 5}; // 5
        System.out.println(peakIndexInMountainArray.peakIndexInMountainArray(F));
    }
}
