package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-01-21
 **/
public class DifferentPath63 {
    public static void main(String[] args) {
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = getPath(input);
        System.out.println(res);

    }


    public static int getPath(int[][] input) {
        if (input[0][0] == 1) return 0;
        input[0][0] = 1;
        int row = input.length;
        int col = input[0].length;
        boolean rowBlock = false;
        boolean colBlock = false;
        int[][] array = new int[row][col];
        for (int i = 1; i < row; i++) {
            if (input[i][0] == 1) {
                rowBlock = true;
            }
            if (rowBlock) {
                array[i][0] = 0;
            } else {
                array[i][0] = 1;
            }
        }

        for (int i = 1; i < col; i++) {
            if (input[0][i] == 1) {
                colBlock = true;
            }
            if (colBlock) {
                array[0][i] = 0;
            } else {
                array[0][i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (input[i][j] == 1) {
                    array[i][j] = 0;
                    continue;
                }
                array[i][j] = array[i][j - 1] + array[i - 1][j];
            }
        }
        return array[row - 1][col - 1];
    }
}
