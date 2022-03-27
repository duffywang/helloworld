package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @auther : wangyufei
 * @date : 2019-10-03
 **/
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 2, 3, 3);
        //distinct example
        List<Integer> res = list.stream()
                                .distinct()
                                .collect(toList());
        System.out.println(res);

        //filter example
        List<Integer> res2 = list.stream()
                                .filter(i -> i < 3)
                                .collect(toList());
        System.out.println(res2);

        //limit exam
        List<Integer> res3 = list.stream()
                                .limit(3)
                                .collect(toList());
        System.out.println(res3);

        //map example
        List<Integer> res4 = list.stream()
                                .map(i -> i + 1)
                                .collect(toList());
        System.out.println(res4);

        //skip example
        List<Integer> res5 = list.stream()
                                .skip(3)
                                .collect(toList());
        System.out.println(res5);

        //findAny Example
        boolean res6 = list.stream()
                            .anyMatch(integer -> integer == 2);
        System.out.println(res6);

        //parallelStream Example mean what
        List<Integer> res7 = list.parallelStream()
                                 .collect(toList());
        System.out.println(res7);

        long res8 = list.stream().count();
        System.out.println(res8);

        //forEach println Example
        list.forEach(System.out::println);



    }
}
