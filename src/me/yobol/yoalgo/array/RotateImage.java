package me.yobol.yoalgo.array;

public class RotateImage {

    /**
     * Given a matrix of n x n elements (n-D square matrix),
     * rotate this matrix by 90 degrees clockwise.
     * Rotate the given matrix by the way of layer-by-layer.
     * @param matrix
     * @return
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int ltr = 0, ltc = 0;
        int rbr = matrix.length - 1, rbc = matrix[0].length - 1;
        while (ltr < rbr) {
            rotateLayer(matrix, ltr++, ltc++, rbr--, rbc--);
        }
    }

    /**
     *
     * @param matrix The specified matrix to be rotated by 90 degrees clockwise.
     * @param ltr row index of the left-top element of matrix
     * @param ltc column index of the left-top element of matrix
     * @param rbr row index of the right-bottom element of matrix
     * @param rbc column index of the right-bottom element of matrix
     * @return
     */
    private void rotateLayer(int[][] matrix, int ltr, int ltc, int rbr, int rbc) {
        int gap = rbr - ltr;
        int tmp;
        for (int i = 0; i < gap; i++) {
            tmp = matrix[ltr][ltc + i];
            matrix[ltr][ltc + i] = matrix[rbr - i][ltc];
            matrix[rbr -i][ltc] = matrix[rbr][rbc - i];
            matrix[rbr][rbc - i] = matrix[ltr + i][rbc];
            matrix[ltr + i][rbc] = tmp;
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(matrix);
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
