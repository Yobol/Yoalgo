package me.yobol.yoalgo.dynamicprogramming;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 如果台阶只有1阶，方法只有1种；
 * 如果台阶有2阶，方法有2种；
 * 如果台阶有n阶，最后跳上第n阶的情况，要么是从第n - 2阶直接跳两阶，要么是从第n - 1阶跳一阶，
 * 所以跨上第n阶的方法数为跨上第n - 2阶的方法数加上跨上第n - 1阶的的方法数。
 * 即S(1) = 1, S(2) = 2, S(n) = S(n - 2) + S(n - 1) n > 2
 *
 * 状态矩阵也是base = {{1, 1}, {1, 0}}
 * (S(n), S(n - 1)) = (S(2), S(1)) X base ^ (n - 2)
 */
public class JumpFloor {

    /**
     * O(log n)
     * @param n
     */
    public int jumpFloor(int n) {
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
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.jumpFloor(3));
    }
}
