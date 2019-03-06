package me.yobol.yoalgo.dynamicprogramming;

/**
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class FibonacciSequence {

    /**
     * 递归法
     * O(2 ^ n)
     * @param n
     * @return
     */
    public int fabonacci1(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fabonacci1(n - 1) + fabonacci1(n - 2);
        }
    }

    /**
     * 迭代法
     * O(n)
     * @param n
     */
    public int fabonacci2(int n) {
        if (n < 1) return 0;

        if (n == 1 || n == 2) return 1;

        int res = 1;
        int pre = 1;
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = tmp + pre;
            pre = tmp;
        }
        return res;
    }

    /**
     * 动态规划
     * O(log n)
     * @param n
     */
    public int fabonacci3(int n) {
        if (n < 1) return 0;

        if (n == 1 || n == 2) return 1;

        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    /**
     * 计算二维矩阵matrix的n-2次方
     */
    private int[][] matrixPower(int[][] matrix, int p) {
        int[][] res = new int[matrix.length][matrix[0].length];
        // 先把res设为单位矩阵
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        int[][] tmp = matrix;
        for (; p != 0; p >>= 1) {
            if ((p & 1) == 1) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }
        return res;
    }

    /**
     * 矩阵乘法
     * 计算m1 x m2
     */
    private int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        System.out.println(fibonacciSequence.fabonacci3(7));
    }
}
