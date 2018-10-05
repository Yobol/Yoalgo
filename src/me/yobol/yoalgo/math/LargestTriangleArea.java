package me.yobol.yoalgo.math;

/**
 * Description:
 * You have a list of points in the plane.
 * Return the area of the largest triangle that can be formed by any 3 of the points.
 * <p>
 * Example:Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * <p>
 * Notes:
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 * -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for (int x = 0; x < points.length - 2; x++) {
            for (int y = x + 1; y < points.length - 1; y++) {
                for (int z = y + 1; z < points.length; z++) {
                    maxArea = Math.max(maxArea, areaCal(points[x], points[y], points[z]));
                }
            }
        }
        return maxArea;
    }

    private double areaCal(int[] pt1, int[] pt2, int[] pt3) {
        return Math.abs(pt1[0] * (pt2[1] - pt3[1]) + pt2[0] * (pt3[1] - pt1[1]) + pt3[0] * (pt1[1] - pt2[1])) / 2.0;
    }


    public static void main(String[] args) {
        LargestTriangleArea lta = new LargestTriangleArea();
        int[][] points = new int[][]{{0, 0}, {0,1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(lta.largestTriangleArea(points));
    }
}
