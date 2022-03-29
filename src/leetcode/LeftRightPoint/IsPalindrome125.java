package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-09-26
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 分析:AmanaplanacanalPanama -> amanaplanacanalpanama 将其他非字母和数字的略过
 * 总结：回文的常见的3种做法：双指针，栈，reverse
 **/
public class IsPalindrome125 {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
