package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-09-29
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * [[1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]]
 * 5
 * ]
 * <p>
 * 思路: 从左下（或右上）作为起始节点出发，如果目标值比现位置小，则上移，否则右移
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class SearchMatrix1009 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (target < matrix[x][y]) {
                x--;
            } else if (target > matrix[x][y]) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean res = searchMatrix(matrix, 5);
        System.out.println(res);
    }
}
