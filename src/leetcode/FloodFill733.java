package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-09-17
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * <p>
 * 公式见公众号：labuladong
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

public class FloodFill733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int orignColor = image[sr][sc];
        int[][] visit = new int[image.length][image[0].length];
        fillImage2(image, sr, sc, orignColor, newColor);
        return image;
    }

    //备忘录算法
    private static void fillImage(int[][] image, int sr, int sc, int orignColor, int newColor, int[][] visit) {
        if (!inBound(image, sr, sc)) return;

        if (visit[sr][sc] == 1 || image[sr][sc] != orignColor) return;

        visit[sr][sc] = 1;
        image[sr][sc] = newColor;
        fillImage(image, sr, sc - 1, orignColor, newColor, visit);
        fillImage(image, sr, sc + 1, orignColor, newColor, visit);
        fillImage(image, sr - 1, sc, orignColor, newColor, visit);
        fillImage(image, sr + 1, sc, orignColor, newColor, visit);
    }

    private static boolean inBound(int[][] image, int sr, int sc) {
        int row = image.length;
        int col = image[0].length;
        if (sr < 0 || sc < 0 || sr >= row || sc >= col) return false;
        return true;
    }


    //回溯算法
    private static void fillImage2(int[][] image, int sr, int sc, int orignColor, int newColor) {
        if (!inBound(image, sr, sc)) return;

        if (image[sr][sc] != orignColor) return;

        if (image[sr][sc] == -1) return;
        image[sr][sc] = -1;
        fillImage2(image, sr, sc - 1, orignColor, newColor);
        fillImage2(image, sr, sc + 1, orignColor, newColor);
        fillImage2(image, sr - 1, sc, orignColor, newColor);
        fillImage2(image, sr + 1, sc, orignColor, newColor);
        image[sr][sc] = newColor;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(array, 1, 1, 2);
        for (int[] arr : array) {
            for (int i : arr) {
                System.out.println(i);
            }
        }

    }
}
