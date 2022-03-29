package leetcode;

/**
 * @auther : wangyufei
 * @date : 2022-01-12
 **/
public class GameOfLife289 {
    public static void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = getCellNumber(i, j, board, row, col);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    public static int getCellNumber(int i, int j, int[][] board, int row, int col) {
        int sum = 0;
        if (i > 0 && j > 0) sum += board[i - 1][j - 1];
        if (i > 0) sum += board[i - 1][j];
        if (i > 0 && j < col - 1) sum += board[i - 1][j + 1];
        if (j > 0) sum += board[i][j - 1];
        if (j < col - 1) sum += board[i][j + 1];
        if (i < row - 1 && j > 0) sum += board[i + 1][j - 1];
        if (i < row - 1) sum += board[i + 1][j];
        if (i < row - 1 && j < col - 1) sum += board[i + 1][j + 1];

        if (board[i][j] == 1 && sum < 2) return 0;
        else if (board[i][j] == 1 && (sum == 2 || sum == 3)) return 1;
        else if (board[i][j] == 1 && sum > 3) return 0;
        else if (board[i][j] == 0 && sum == 3) return 1;
        else return board[i][j];
    }


    private static final int[] DX = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] DY = {1, -1, 0, 0, 1, -1, 1, -1};

    public void gameOfLife2(int[][] board) {
        if (board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + DX[k];
                    int y = j + DY[k];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }
                    // 这里不能直接加board[x][y]，因为 board[x][y] 的倒数第二位是可能有值的。
                    cnt += board[x][y] & 1;
                }
                if ((board[i][j] & 1) > 0) {
                    // 这个是活细胞
                    if (cnt >= 2 && cnt <= 3) {
                        // 周围有2/3个活细胞，下一个状态还是活细胞。
                        board[i][j] = 0b11;
                    }
                    // 周围活细胞过多或过少都会死，因为原数据是0b01，所以这里不用额外赋值。
                } else if (cnt == 3) {
                    // 这个是死细胞，周围有3个活细胞，下一个状态变为活细胞。
                    board[i][j] = 0b10;
                }
            }
        }
        // 最后一位去掉，倒数第二位变为更新后的状态。
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
    }
}
