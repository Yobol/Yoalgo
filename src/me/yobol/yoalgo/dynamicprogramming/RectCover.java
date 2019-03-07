package me.yobol.yoalgo.dynamicprogramming;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 *
 * 和JumpFloor问题解法相同
 * f(1) = 1; f(2) = 2;
 * f(3) = f(2) + f(1)
 * f(4) = f(3) + f(2)
 *
 * f(n) = f(n - 1) + f(n - 2)
 */
public class RectCover {
    /**
     * O(log n)
     * @param n
     */
    public int rectCover(int n) {
        if (n < 1) return 0;

        if (n == 1 || n == 2) return n;

        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return 2 * res[0][0] + res[1][0];
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
        RectCover rectCover = new RectCover();
        System.out.println(rectCover.rectCover(6));
    }
}
