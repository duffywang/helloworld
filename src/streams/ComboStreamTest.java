package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * RR
 *
 * @auther : wangyufei
 * @date : 2019-10-03
 **/
public class ComboStreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("duffy", "seu", "dianping", "yuki", "pku", "luffy");
        List<Integer> res1 = list.stream()
                .sorted()
                .map(i -> i.length())
                .distinct()
                .collect(toList());
        System.out.println(res1);

        List<String> res2 = list.stream()
                .map(i -> i + " : " + i.length())
                .sorted()
                .collect(toList());

        System.out.println(res2);


        List<String> res3 = list.stream()
                .sorted()
                .map(i -> i.length() + " : " + i)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.charAt(0) - o2.charAt(0);
                    }
                })
                .collect(toList());
        System.out.println(res3);


        Set<String> res4 = list.stream().flatMap(s -> Stream.of(s.split(" +"))).collect(toSet());
        System.out.println(res4);


    }

}
