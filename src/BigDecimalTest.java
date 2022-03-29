import java.math.BigDecimal;

/**
 * @auther : wangyufei
 * @date : 2019-07-09
 **/
public class BigDecimalTest {
    private static Boolean flag;

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(new Double(1.262));
        BigDecimal res = bigDecimal.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println("res = " + res);

        System.out.println("flag = " + flag);

    }
}
