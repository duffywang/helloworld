package leetcode;

import java.util.Scanner;

/**
 * @auther : wangyufei
 * @date : 2020-01-20
 * 从二维矩阵的左上角到右下角，只能向右移动或者想下移动，问一共有多少种路径可以到达
 **/
public class DifferentPath62 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0,n =0;
        if (sc.hasNext()){
            m = sc.nextInt();
            n = sc.nextInt();
        }
        {
            int path = getPath2(m, n);
            System.out.println(path);
        }

    }

    public static int getPath(int m,int n){
        int[][] input = new int[m][n];
        for (int i = 0; i < m; i++) {
            input[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            input[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                input[i][j] = input[i][j-1] + input[i-1][j];
            }
        }
        return input[m-1][n-1];

    }


    public static int getPath2(int m,int n){
        int[][] input = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){
                    input[i][j] = 1;
                }else {
                    //类似青蛙跳台阶，结果等于左边节点和上边节点的和
                    input[i][j] = input[i-1][j] + input[i][j-1];
                }
            }
        }
        return input[m-1][n-1];
    }
}
