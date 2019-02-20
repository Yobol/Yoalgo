package me.yobol.yoalgo.array;

public class ZigZagMatrix {

    /**
     * Print the given matrix in zigzag order.
     * @param matrix
     */
    public void zigZag(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        // Variables having prefix 'rb' mean the they move firstly to right, then move to bottom.
        int rbr = 0, rbc = 0;
        // Variables having prefix 'br' mean the they move firstly to bottom, then move to right.
        int brr = 0, brc = 0;
        int er = matrix.length - 1, ec = matrix[0].length - 1;
        // If fromUp is false, print the line from (rbr, rbc) to (brr, brc),else reverse it.
        boolean fromUp = false;

        while (rbr != er + 1) {
            printLine(matrix, rbr, rbc, brr, brc, fromUp);
            rbr = rbc == ec ? rbr + 1 : rbr;
            rbc = rbc == ec ? rbc : rbc + 1;
            brc = brr == er ? brc + 1 : brc;
            brr = brr == er ? brr : brr + 1;
            fromUp = !fromUp;
        }
    }

    /**
     * Print the line specified by (rbr, rbc) and (brr, brc).
     * @param matrix
     * @param rbr
     * @param rbc
     * @param brr
     * @param brc
     * @param fromUp
     */
    public void printLine(int[][] matrix, int rbr, int rbc, int brr, int brc, boolean fromUp) {
        if (fromUp) {
            while (rbr != brr + 1) {
                System.out.print(matrix[rbr++][rbc--] + " ");
            }
        } else {
            while (brr != rbr - 1) {
                System.out.print(matrix[brr--][brc++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        ZigZagMatrix zigZagMatrix = new ZigZagMatrix();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        zigZagMatrix.zigZag(matrix);
    }
}
