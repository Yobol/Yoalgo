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
        double area = 0;
        for (int x = 0; x < points.length; x++) {
            for (int y = 1; y < points.length; y++) {
                if (x == y) break;
                double a = Math.sqrt(Math.pow(points[x][0] - points[y][0], 2) + Math.pow(points[x][1] - points[y][1], 2));
                for (int z = 2; z < points.length; z++) {
                    if (x == z || y == z) break;
                    double b = Math.sqrt(Math.pow(points[x][0] - points[z][0], 2) + Math.pow(points[x][1] - points[z][1], 2));
                    double c = Math.sqrt(Math.pow(points[y][0] - points[z][0], 2) + Math.pow(points[y][1] - points[z][1], 2));
                    if (a + b > c || a + c > b || b + c > a) {
                        area = 0.5 * a * b * Math.sin(c);
                    }
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        LargestTriangleArea lta = new LargestTriangleArea();
        int[][] points = new int[][]{{0, 0}, {0,1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(lta.largestTriangleArea(points));
    }
}
