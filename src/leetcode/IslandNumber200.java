package leetcode;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * output:
 * 1
 *
 * @auther : wangyufei
 * @date : 2020-02-01
 **/
public class IslandNumber200 {
    public static void main(String[] args) {


    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int sum = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    dfs(grid, i, j);
                }
            }
        }
        return sum;

    }

    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }
        //连接在一起的陆地1，被设置为0，循环的时候就不会再++
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);

    }
}
