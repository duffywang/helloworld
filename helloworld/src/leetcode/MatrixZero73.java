package leetcode;

import java.util.HashSet;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * @auther : wangyufei
 * @date : 2020-02-15
 **/
public class MatrixZero73 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1,}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }

    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

//        for (Integer r : row) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[r][j] = 0;
//            }
//        }
//        for (Integer c : col) {
//            for (int i = 0; i < matrix.length; i++) {
//                matrix[i][c] = 0;
//            }
//        }


    }
}
