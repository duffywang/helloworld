package leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-09-20
 * <p>
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class PondSizes1619 {
    public int[] pondSizes(int[][] land) {
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    count = dfs(land, i, j);
                    res.add(count);
                }
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        Arrays.sort(array);
        return array;
    }

    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0) return 0;
        land[i][j] = -1;
        int count = 1;
        count = count + dfs(land, i - 1, j) + dfs(land, i + 1, j) + dfs(land, i, j - 1) + dfs(land, i, j + 1) + dfs(land, i - 1, j - 1) + dfs(land, i - 1, j + 1) + dfs(land, i + 1, j - 1) + dfs(land, i + 1, j + 1);
        return count;
    }
}
