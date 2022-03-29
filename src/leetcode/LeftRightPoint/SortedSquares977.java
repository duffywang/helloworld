package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-09-26
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 **/
public class SortedSquares977 {
    public static int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int left = 0, right = len - 1;
        int i = len - 1;
        while (left <= right) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                res[i--] = A[left] * A[left];
                left++;
            } else {
                res[i--] = A[right] * A[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-7, -3, 2, 3, 11};
        int[] res = sortedSquares(array);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
