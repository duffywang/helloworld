package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-08-10
 **/
public class Main {
    public static String func(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int max = Math.max(lena, lenb);
        StringBuilder sb = new StringBuilder();
        int tempa = 0;
        int tempb = 0;
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < max; i++) {
            if (lena - i - 1 >= 0) {
                tempa = a.charAt(lena - i - 1) - '0';
            } else {
                tempa = 0;
            }
            if (lenb - i - 1 >= 0) {
                tempb = b.charAt(lenb - i - 1) - '0';
            } else {
                tempb = 0;
            }
            if (flag) {
                temp = (tempa + tempb + 1) % 10;
            } else {
                temp = (tempa + tempb) % 10;
            }
            flag = flag ? (tempa + tempb + 1) / 10 >= 1 : (tempa + tempb) >= 1;
            sb.append(temp);
        }
        if (flag) sb.append(1);
        return sb.reverse().toString();
    }

    public static double func2(double a, double b){
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        String[] aArray = aStr.split("\\.");
        String[] bArray = bStr.split("\\.");
        String pre = func(aArray[0], bArray[0]);
        String post = func(new StringBuilder(aArray[1]).reverse().toString(), new StringBuilder(bArray[1]).reverse().toString());
        StringBuilder res = new StringBuilder(pre).append(".").append(new StringBuilder(post).reverse().toString());
        return Double.valueOf(res.toString());
    }

    public static void main(String[] args) {
        double res = Main.func2(3.12, 0.01);
        System.out.println(res);
    }
}
