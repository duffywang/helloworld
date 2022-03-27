import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2019-11-04
 **/
public class MapTest {
    public static void main(String[] args) {

        int input = 40100;
        BigDecimal bg = new BigDecimal((double)input/10000);
        BigDecimal res = bg.setScale(1, BigDecimal.ROUND_CEILING);
        System.out.println(res);

        String str = "string";
        System.out.println(str.concat(""));
        HashMap<Object, Object> map = new HashMap<>();
        map.put("asd", null + "_x");
        System.out.println(map);

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = simpleDateFormat.format(date);
        System.out.println(result);


    }
}
