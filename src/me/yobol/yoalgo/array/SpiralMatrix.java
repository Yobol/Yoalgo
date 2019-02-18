package me.yobol.yoalgo.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     *
     * @param matrix The specified matrix to be print in spiral target.
     * @param ltr row index of the left-top element of matrix
     * @param ltc column index of the left-top element of matrix
     * @param rbr row index of the right-bottom element of matrix
     * @param rbc column index of the right-bottom element of matrix
     * @return
     */
    private List<Integer> printLayer(int[][] matrix, int ltr, int ltc, int rbr, int rbc) {
        List<Integer> list = new ArrayList();
        if (ltr == rbr) { // when layer only spans one row
            for (int c = ltc; c <= rbc; c++) {
                list.add(matrix[ltr][c]);
            }
        } else if (ltc == rbc) { // when layer only spans one column
            for (int r = ltr; r <= rbr; r++) {
                list.add(matrix[r][ltc]);
            }
        } else { // when layer spans more than one row and one column
            int c = ltc;
            int r = ltr;
            // traverse top elements of layer
            while (c != rbc) {
                list.add(matrix[ltr][c]);
                c++;
            }
            // traverse right elements of layer
            while (r != rbr) {
                list.add(matrix[r][rbc]);
                r++;
            }
            // traverse bottom elements of layer
            while (c != ltc) {
                list.add(matrix[rbr][c]);
                c--;
            }
            // traverse left elements of layer
            while (r != ltr) {
                list.add(matrix[r][ltc]);
                r--;
            }
        }
        return list;
    }

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * Traverse all elements of the given matrix in way to layer-by-layer.
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int ltr = 0, ltc = 0;
        int rbr = matrix.length - 1, rbc = matrix[0].length - 1;
        while (ltc <= rbc && ltr <= rbr) {
            list.addAll(printLayer(matrix, ltr++, ltc++, rbr--, rbc--));
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }
}
