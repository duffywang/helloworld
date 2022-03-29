package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2021-06-14
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 输入：
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * 输出：
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 **/
public class UpdateMatrix542 {

    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int i = 0; i < 4; i++) {
                int xNew = x + dx[i];
                int yNew = y + dy[i];
                if (xNew >= 0 && xNew < mat.length && yNew >= 0 && yNew < mat[0].length && mat[xNew][yNew] == -1) {
                    mat[xNew][yNew] = mat[x][y] + 1;
                    queue.offer(new int[]{xNew, yNew});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = updateMatrix(mat);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
