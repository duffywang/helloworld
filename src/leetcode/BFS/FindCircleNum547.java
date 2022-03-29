package leetcode.BFS;

import java.util.HashSet;

/**
 * @auther : wangyufei
 * @date : 2021-08-08
 **/
public class FindCircleNum547 {
    /**
     * {{1,0,0,1},{0,1,1,0},{1,1,0,1},{1,0,1,0}}
     * 在这个测试用例下预期是1，结果为2
     */
    public static int findCircleNum(int[][] isConnected) {
        HashSet<Integer> set = new HashSet<>();
        int row = isConnected.length;
        int col = isConnected[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            boolean flag = false;
            for (int j = 0; j < col; j++) {
                if (isConnected[i][j] == 1) {
                    if (set.contains(j)) {
                        break;
                    }
                    flag = true;
                    set.add(j);
                }
            }
            if (flag) count++;
        }
        return count;
    }

    /**
     * 深度优先
     */
    public static int findCircleNum2(int[][] isConnected) {
        int row = isConnected.length;
        boolean[] visit = new boolean[row];
        int res = 0;
        for (int i = 0; i < row; i++) {
            if (!visit[i]) {
                dfs(i, visit, isConnected, row);
                res++;
            }
        }
        return res;

    }

    private static void dfs(int i, boolean[] visit, int[][] isConnected, int row) {
        for (int j = 0; j < row; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(j, visit, isConnected, row);
            }
        }
    }

    /**
     * 并查集
     */
    public static int findCircleNum3(int[][] isConnected) {
        int row = isConnected.length;
        int[] parent = new int[row];
        for (int i = 0; i < row; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                if (isConnected[i][j] == 1) union(parent, i, j);
            }
        }
        int res = 0;
        for (int i = 0; i < row; i++) {
            if (parent[i] == i) res++;
        }
        return res;
    }

    private static void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);

    }

    private static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }


    public static void main(String[] args) {
        int[][] array = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int res = findCircleNum2(array);
        System.out.println(res);
    }
}
