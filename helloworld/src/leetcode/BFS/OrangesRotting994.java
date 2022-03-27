package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2020-12-06
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class OrangesRotting994 {
    public static int orangesRotting(int[][] grid) {
        int res = 0;
        int count = 0;//Fresh orange count
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    count++;
                }else if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(count > 0 && !queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (isFresh(r, c - 1, grid)) {
                    grid[r][c - 1] = 2;
                    count--;
                    queue.add(new int[]{r, c - 1});
                }
                if (isFresh(r, c + 1, grid)) {
                    grid[r][c + 1] = 2;
                    count--;
                    queue.add(new int[]{r, c + 1});
                }
                if (isFresh(r - 1, c, grid)) {
                    grid[r - 1][c] = 2;
                    count--;
                    queue.add(new int[]{r - 1, c});
                }
                if (isFresh(r + 1, c, grid)) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[]{r + 1, c});
                }

            }
        }
        return count > 0 ? -1 : res;
    }

    private static boolean isFresh(int i, int j, int[][] grid) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int res = orangesRotting(grid);
        System.out.println(res);
    }
}
