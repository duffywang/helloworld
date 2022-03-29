import java.util.Scanner;

/**
 * @auther : wangyufei
 * @date : 2019-10-16
 **/
public class reverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(s.length() - 1 - i));
        }

    }
}
