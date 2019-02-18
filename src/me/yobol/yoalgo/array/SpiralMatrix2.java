package me.yobol.yoalgo.array;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int num = 1;
        int ltr = 0, ltc = 0;
        int rbr = n - 1, rbc = n - 1;
        while (ltr <= rbr && ltc <= rbc) {
            if (ltr == rbr && ltc == rbc) { // the central sub-matrix of matrix, and it only have 1 element.
                matrix[ltr][ltc] = num++;
            } else {
                int r = ltr, c = ltc;
                while (c != rbc) {
                    matrix[ltr][c] = num++;
                    c++;
                }
                while (r != rbr) {
                    matrix[r][rbc] = num++;
                    r++;
                }
                while (c != ltc) {
                    matrix[rbr][c] = num++;
                    c--;
                }
                while (r != ltr) {
                    matrix[r][ltc] = num++;
                    r--;
                }
            }
            ltr++;
            ltc++;
            rbr--;
            rbc--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        int[][] matrix = spiralMatrix2.generateMatrix(3);
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
