package swordoffer;

import java.util.Scanner;

/**
 * @auther : wangyufei
 * @date : 2019-11-03
 **/
public class FindTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 11;
        boolean res = findTarget(target,input);
        System.out.println(res);
    }

    private static boolean findTarget(int target, int[][] input) {
        int len = input.length;
        int height = input[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = height-1; j >= 0 ; j--) {
                if (input [i][j] > target){
                    continue;
                }else if (input [i][j] < target){
                    break;
                }else {
                    return true;
                }
            }
        }
        return false;
    }


}
