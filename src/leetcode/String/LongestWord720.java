package leetcode.String;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @auther : wangyufei
 * @date : 2022-03-21
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 * <p>
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * <p>
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LongestWord720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<Object> set = new HashSet<>();
        String res = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                res = word.length() > res.length() ? word : res;
                set.add(word);
            }
        }
        return res;
    }


    /*
     * 学习字典树，学习新知识了
     * */
    public String longestWord2(String[] words) {
        Arrays.sort(words);
        String ans = "";
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
            if (trie.inDictionary(word) && word.length() > ans.length()) {
                ans = word;
            }
        }
        return ans;
    }


    /*
     * 字典树模板
     * */
    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /*
         * 构建字典树，插入节点
         * */
        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                //往下走一层
                cur = cur.children[c - 'a'];
            }
            cur.exist = true;
        }

        boolean inDictionary(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                cur = cur.children[c - 'a'];
                if (cur == null || !cur.exist) {
                    return false;
                }
            }
            return true;
        }


    }

    /*
     * 字典树节点
     * */
    class TrieNode {
        boolean exist;
        //递归下去
        TrieNode[] children;

        TrieNode() {
            exist = false;
            children = new TrieNode[26];
        }
    }

}
