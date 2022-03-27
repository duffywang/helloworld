package leetcode;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * output : true
 *
 * @auther : wangyufei
 * @date : 2020-01-30
 * [0,0] [0,1] [0,2]
 * [1,0] [1,1] [1,2]
 * [2,0] [2,1] [2,2]
 **/
public class ValidSudoku36 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        //记录某行/列/块，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j];
                    /** 块的索引
                     * 0 1 2
                     * 3 4 5
                     * 6 7 8
                     */
                    int index = (i / 3) * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[index][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[index][num] = true;
                    }
                }
            }
        }
        return true;

    }

    public boolean isValidSudoku2(char[][] board) {

        for (int i = 0; i < 9; i++) {
            int[] init = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int index = board[i][j];
                if (init[index - '1'] == 0) {
                    return false;
                }
                init[index - '1'] = 0;
            }
        }
        for (int i = 0; i < 9; i++) {
            int[] init = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int index = board[j][i];
                if (init[index - '1'] == 0) {
                    return false;
                }
                init[index - '1'] = 0;
            }
        }
        return true;

    }
}
