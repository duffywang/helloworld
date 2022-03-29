package src;

import java.util.*;

/**
 * @auther : wangyufei
 * @date : 2019-07-20
 **/
public class ValueOfTest {
    public static void main(String[] args) {
        String s = null;
        //String s1 = s.toString();
        String s2 = String.valueOf(s);
        //System.out.println(s1);
        System.out.println(s2);

        List emptyList = Collections.EMPTY_LIST;
        Map emptyMap = Collections.EMPTY_MAP;
        Set emptySet = Collections.EMPTY_SET;


        HashMap<Object, Object> map = null;

        Object test = map.get("test");
        if (map.containsKey("test")) {
            System.out.println(map.get("test"));
        }
    }
}
