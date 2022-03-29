package leetcode.LeftRightPoint;

import java.util.HashSet;

/**
 * @auther : wangyufei
 * @date : 2020-09-26
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 **/
public class ReverseVowel345 {
    public static String reverseVowels(String s) {
        HashSet set = new HashSet<Character>();
        char[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] str = s.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !set.contains(str[left])) {
                left++;
            }
            while (left < right && !set.contains(str[right])) {
                right--;
            }
            if (left < right) {
                swapChar(str, left, right);
                //注意 否则永远一对交换
                left++;
                right--;
            }
        }
        return String.valueOf(str);
    }

    private static void swapChar(char[] str, int left, int right) {
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }

    public static void main(String[] args) {
        String res = reverseVowels("leetcode");
        System.out.println(res);
    }
}
