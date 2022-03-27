package leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2021-07-21
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 **/
public class Combine77 {

    /**
     * 常规无剪枝做法
     * 记住整个框架
     * */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, 1, n, k);
        return res;

    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int begin, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= n; i++) {
            list.add(i);
            //注意是i+1 不要写成 begin+1了
            helper(res, list, i + 1, n, k);
            list.remove(list.size() - 1);

        }
    }


    /**
     * 剪枝方法 举例:n = 4 k =3
     * 1      2      3
     * 2 3    3 4    4
     * 3 4 4  4   X  X
     */
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine2(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 3);
        for (List<Integer> re : res) {
            for (Integer r : re) {
                System.out.print(r + " ");
            }
        }
    }

}
