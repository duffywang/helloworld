package leetcode;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * input:[1,1,1,2,2,3] 2
 * output:[1,2]
 *
 * @auther : wangyufei
 * @date : 2020-02-10
 **/
public class TopKElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        List<Integer> res = topKFrequent(nums, 2);
        for (Integer re : res) {
            System.out.println(re);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");

        Date date = new Date(1581630631239L);
        if (date == null) {
            System.out.println();
        } else {
            String format = sdf.format(date);
            System.out.println(format);
        }


    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }
}
