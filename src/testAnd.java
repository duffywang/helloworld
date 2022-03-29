import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @auther : wangyufei
 * @date : 2019-08-29
 **/
public class testAnd {
    public static void main(String[] args) {
        String str = "1,5,3,4,21";
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(str.split(",")));
        boolean contains = strings.contains("21");
        System.out.println(contains);
        HashMap<Object, Object> map = new HashMap<>();


        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.clear();
        list.add("4");
        list.add("3");
        list.add("2");
        list.add("1");
        for (String s : list) {
            System.out.println(s);
        }


    }
}
