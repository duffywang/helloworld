package streams;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @auther : wangyufei
 * @date : 2019-10-03
 **/
public class complexStreamTest {
    public static void main(String[] args) {
        streams.Dish dish1 = new streams.Dish("fish", 15, "good");
        streams.Dish dish2 = new streams.Dish("beef", 22, "excelent");
        streams.Dish dish3 = new streams.Dish("tomato", 9, "fresh");

        List<streams.Dish> list = Arrays.asList(dish1, dish2, dish3);

//        List<String> res = list.stream().filter(d -> d.getPrice() > 10).map(m -> m.getName() + " : " + m.getReview()).collect(toList());
//        System.out.println(res);

        List<String> dishList = list.stream()
                .filter(dish -> dish.getPrice() > 10)
                .map(dish -> dish.getName())
                .collect(toList());

        dishList.stream()
                .forEach(name -> System.out.println(name));


    }
}
