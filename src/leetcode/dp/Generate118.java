package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2021-06-26
 **/
public class Generate118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;

    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
