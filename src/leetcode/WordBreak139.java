package leetcode;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * @auther : wangyufei
 * @date : 2020-01-29
 **/
public class WordBreak139 {
    public static void main(String[] args) {
        String str = "catsanddog";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cat");
        arrayList.add("sand");
        arrayList.add("dog");
        arrayList.add("cats");
        arrayList.add("and");
        boolean res = wordBreak(str, arrayList);
        System.out.println(res);

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (set.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

//    public static boolean wordBreak2(String s, List<String> wordDict){
//
//    }
}
