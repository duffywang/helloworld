package leetcode;

/**
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
 * 如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * input:A:abcde B:bcdea
 * output:true
 *
 * @auther : wangyufei
 * @date : 2020-02-16
 **/
public class ReverseString796 {
    public static void main(String[] args) {
        String A = "abcde";
        String B = "dcabe";
        boolean res = rotateString2(A, B);
        System.out.println(res);

    }

    public static boolean rotateString(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        if (lenA == 0 && lenB == 0)return true;
        if (lenA != lenB) return false;
        for (int i = 0; i < lenA; i++) {
            char c = A.charAt(0);
            A = A.substring(1).concat(String.valueOf(c));
            if (A.equals(B)) return true;
        }
        return false;
    }

    public static boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
