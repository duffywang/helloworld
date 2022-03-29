package streams;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther : wangyufei
 * @date : 2020-05-22
 **/
public class LRUMap extends LinkedHashMap {

    private final int max = 10;
    private Object lock;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > max;
    }

    @Override
    public Object get(Object key) {
        synchronized (lock) {
            return super.get(key);
        }
    }

    @Override
    public Object put(Object key, Object value) {
        synchronized (lock) {
            return super.put(key, value);
        }
    }

    @Override
    public Object remove(Object key) {
        synchronized (lock) {
            return super.remove(key);
        }
    }
}
