package me.yobol.yoalgo.array;


/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class SelectTargetFromRowAndColumnSortedArray {

    /**
     * 从矩阵的左下角或者右上角开始寻找。
     * 以右上角为例
     * @param matrix
     * @param target
     * @return
     */
    public boolean isContains(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SelectTargetFromRowAndColumnSortedArray s = new SelectTargetFromRowAndColumnSortedArray();
        int[][] matrix = {{1, 2 ,3}, {4, 5, 6}};
        System.out.println(s.isContains(matrix, 4));
    }
}
