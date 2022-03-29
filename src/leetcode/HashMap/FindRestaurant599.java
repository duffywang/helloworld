package leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2022-03-14
 **/
public class FindRestaurant599 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int index1 = 0, index2 = 0;
        for (String str1 : list1) {
            map1.put(str1, index1++);
        }
        int min = Integer.MAX_VALUE, temp = 0;
        for (String str2 : list2) {
            if (map1.containsKey(str2)) {
                temp = index2 + map1.get(str2);
                if (temp < min) {
                    min = temp;
                }
                map2.put(str2, temp);
            }
            index2++;
        }
        map1.clear();
        index1 = 0;
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == min) {
                map1.put(entry.getKey(), 0);
            }
        }
        int size = map1.size();
        String[] res = new String[size];
        for (String s : map1.keySet()) {
            res[index1++] = s;
        }
        return res;

    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] res = findRestaurant(list1, list2);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
