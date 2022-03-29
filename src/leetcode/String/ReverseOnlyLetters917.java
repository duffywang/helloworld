package leetcode.String;

/**
 * @auther : wangyufei
 * @date : 2022-02-23
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 **/
public class ReverseOnlyLetters917 {
    public static String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(array[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(array[right])) {
                right--;
            }
            swap(array, left, right);
            left++;
            right--;
        }
        return new String(array);
    }

    private static void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
