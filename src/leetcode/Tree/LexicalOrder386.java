package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2022-03-23
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * <p>
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * <p>
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * <p>
 * 深度优先
 **/
public class LexicalOrder386 {
    public static List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, list);
        }
        return list;
    }

    private static void dfs(int n, int i, ArrayList<Integer> list) {
        if (i > n) return;

        list.add(i);
        //找输出结果的规律，构造出10、11、12.....
        for (int j = 0; j <= 9; j++) {
            dfs(n, i * 10 + j, list);
        }
    }

    public static void main(String[] args) {
        List<Integer> res = lexicalOrder(13);

        for (Integer re : res) {
            System.out.println(re);
        }
    }


}
