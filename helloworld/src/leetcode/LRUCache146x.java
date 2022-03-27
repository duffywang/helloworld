package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2020-07-11
 **/
public class LRUCache146x {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache146x(int capacity){
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.74f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(int key, int value){
        cache.put(key, value);
    }

    public int get(int key){
        return cache.getOrDefault(key, -1);
    }

}
