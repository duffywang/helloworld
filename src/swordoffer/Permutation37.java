package swordoffer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther : wangyufei
 * @date : 2020-08-16
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 **/
public class Permutation37 {
    private static List<String> res;
    private static char[] c;

    public static String[] permutation(String s) {
        res = new LinkedList<>();
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private static void dfs(int i) {
        if (i == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < c.length; j++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, j); // 交换，将 c[i] 固定在第 x 位
            dfs(j + 1); // 开启固定第 x + 1 位字符
            swap(i, j); // 恢复交换
        }
    }

    private static void swap(int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) {
        String[] res = permutation("abc");
    }
}
