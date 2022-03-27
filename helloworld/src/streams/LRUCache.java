//package streams;
//
///**
// * @auther : wangyufei
// * @date : 2021-09-03
// **/
//
//import java.util.HashMap;
//
///**
// * @author :dongshuo
// * @date : 2018/12/10 14:27
// * @desc : 链表+hashmap实现的
// */
//public class LRUCache<K, V> {
//    //定义最大的缓存个数
//    private final int MAX_CACHE_SIZE;
//    //头元素
//    private ListNode first;
//    //尾元素
//    private ListNode last;
//
//    //用来保存的ashmap
//    private HashMap<K, ListNode<K, V>> hashMap;
//
//    /**
//     * 初始化 缓存大小和对象
//     *
//     * @param cacheSize
//     */
//    public LRUCache(int cacheSize) {
//        MAX_CACHE_SIZE = cacheSize;
//        hashMap = new HashMap<>();
//    }
//
//    /**
//     * 存入k,v
//     *
//     * @param key
//     * @param value
//     */
//    public void put(K key, V value) {
//        //首先判断是否存在该值
//        ListNode entry = getEntry(key);
//        //如果为空
//        if (entry == null) {
//            if (hashMap.size() >= MAX_CACHE_SIZE) {
//                hashMap.remove(last.key);
//                removeLast();
//            }
//            entry = new ListNode();
//            entry.key = key;
//        }
//        entry.value = value;
//        moveToFirst(entry);
//        hashMap.put(key, entry);
//    }
//
//    public V get(K key) {
//        ListNode<K, V> entry = getEntry(key);
//        if (entry == null) return null;
//        moveToFirst(entry);
//        return entry.value;
//    }
//
//    public void remove(K key) {
//        ListNode entry = getEntry(key);
//        if (entry != null) {
//            if (entry.pre != null) entry.pre.next = entry.next;
//            if (entry.next != null) entry.next.pre = entry.pre;
//            if (entry == first) first = entry.next;
//            if (entry == last) last = entry.pre;
//        }
//        hashMap.remove(key);
//    }
//
//    /**
//     * 将元素移到first
//     *
//     * @param entry
//     */
//    private void moveToFirst(ListNode entry) {
//        //元素已经在first位置了
//        if (entry == first) return;
//        if (entry.pre != null) entry.pre.next = entry.next;
//        if (entry.next != null) entry.next.pre = entry.pre;
//        //元素在last位置
//        if (entry == last) last = last.pre;
//
//        if (first == null || last == null) {
//            first = last = entry;
//            return;
//        }
//
//        //元素放到first
//        entry.next = first;
//        first.pre = entry;
//        first = entry;
//        entry.pre = null;
//    }
//
//    /**
//     * 删除最后一个元素
//     */
//    private void removeLast() {
//        if (last != null) {
//            //last元素被删除,last前驱作为最后一个元素
//            last = last.pre;
//            //如果 first=last情况时
//            if (last == null) {
//                first = null;
//            } else {
//                last.next = null;
//            }
//
//        }
//    }
//
//    /**
//     * 判断map是否存在该key,value
//     *
//     * @param key
//     * @return
//     */
//    private ListNode<K, V> getEntry(K key) {
//        return hashMap.get(key);
//    }
//
//    /**
//     * 内部类 链表
//     *
//     * @param <K>
//     * @param <V>
//     */
//    class ListNode<K, V> {
//        public ListNode pre;
//        public ListNode next;
//        public K key;
//        public V value;
//    }
//
//    public static void main(String[] args) {
//        LRUCache<Integer, Integer> map = new LRUCache<>(4);
//
//        map.put(1, 1);
//        map.put(2, 2);
//        map.put(3, 3);
//        map.put(4, 4);
//        map.put(5, 5);
//    }
//
//    问题1：
//    解题代码：
//
//    public static int maxDiff(int[] nums) {
//        int ans = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
////当前值减去目前i左边的最小值
//            ans = Math.max(ans, nums[i] - min);
////找最小值
//            min = Math.min(min, nums[i]);
//        }
//        return ans;
//    }
//
//
//    {
//        7, 1, 5, 3, 6, 4
//    } 5
//
//    {
//        1, 1, 1, 1, 1, 1
//    } 0
//
//    {
//        5, 4, 3, 2, 1, 0
//    } -1
//
//
//    问题2:
//
//    class Singleton {
//
//        private Singleton() {
//        }
//
//        //饿汉模式，当有请求时才创建对象，实现延迟加载
////volatile修饰防止代码重排序
//        private static volatile Singleton instance;
//
//        public static Singleton getInstance() {
////首次判空可提前过滤部分请求
//            if (instance == null) {
//                synchronized (Singleton.class) {
////可能多线程，保证只创建单个对象
//                    if (instance == null) {
//                        return new Singleton();
//                    }
//                }
//            }
//            return instance;
//        }
//    }
//
//    问题3：
//
//    public int[] bubbleSort(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return nums;
//        }
//        for (int i = nums.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    swap(nums, j, j + 1);
//                }
//            }
//        }
//        return nums;
//    }
//
//    private void swap(int[] nums, int left, int right) {
//        int tmp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = tmp;
//    }
//
//    时间复杂度：
//
//    O(N^2)
//
//    空间复杂度：
//
//    N(1)
//
//    测试案例及运行结果：
//
//    {
//        2, 1, 3, 5, 4, 7, 9, 8
//    } ->
//
//    {
//        1, 2, 3, 4, 5, 7, 8, 9
//    }
//
//    {
//        9, 8, 7, 5, 4, 3, 2, 1
//    } ->
//
//    {
//        1, 2, 3, 4, 5, 7, 8, 9
//    }
//
//    问题4：
//
//    public class LRUCache<K, V> {
//        //定义最大的缓存个数
//        private final int MAX_CACHE_SIZE;
//        //头元素
//        private ListNode first;
//        //尾元素
//        private ListNode last;
//
//        //用来保存的ashmap
//        private HashMap<K, ListNode<K, V>> hashMap;
//
//        /**
//         * 初始化 缓存大小和对象
//         *
//         * @param cacheSize
//         */
//        public LRUCache(int cacheSize) {
//            MAX_CACHE_SIZE = cacheSize;
//            hashMap = new HashMap<>();
//        }
//
//        /**
//         * 存入k,v
//         *
//         * @param key
//         * @param value
//         */
//        public void put(K key, V value) {
////首先判断是否存在该值
//            ListNode entry = getEntry(key);
////如果为空
//            if (entry == null) {
//                if (hashMap.size() >= MAX_CACHE_SIZE) {
//                    hashMap.remove(last.key);
//                    removeLast();
//                }
//                entry = new ListNode();
//                entry.key = key;
//            }
//            entry.value = value;
//            moveToFirst(entry);
//            hashMap.put(key, entry);
//        }
//
//        public V get(K key) {
//            ListNode<K, V> entry = getEntry(key);
//            if (entry == null) return null;
//            moveToFirst(entry);
//            return entry.value;
//        }
//
//        public void remove(K key) {
//            ListNode entry = getEntry(key);
//            if (entry != null) {
//                if (entry.pre != null) entry.pre.next = entry.next;
//                if (entry.next != null) entry.next.pre = entry.pre;
//                if (entry == first) first = entry.next;
//                if (entry == last) last = entry.pre;
//            }
//            hashMap.remove(key);
//        }
//
//        /**
//         * 将元素移到first
//         *
//         * @param entry
//         */
//        private void moveToFirst(ListNode entry) {
////元素已经在first位置了
//            if (entry == first) return;
//            if (entry.pre != null) entry.pre.next = entry.next;
//            if (entry.next != null) entry.next.pre = entry.pre;
////元素在last位置
//            if (entry == last) last = last.pre;
//
//            if (first == null || last == null) {
//                first = last = entry;
//                return;
//            }
//
////元素放到first
//            entry.next = first;
//            first.pre = entry;
//            first = entry;
//            entry.pre = null;
//        }
//
//        /**
//         * 删除最后一个元素
//         */
//        private void removeLast() {
//            if (last != null) {
////last元素被删除,last前驱作为最后一个元素
//                last = last.pre;
////如果 first=last情况时
//                if (last == null) {
//                    first = null;
//                } else {
//                    last.next = null;
//                }
//
//            }
//        }
//
//        /**
//         * 判断map是否存在该key,value
//         *
//         * @param key
//         * @return
//         */
//        private ListNode<K, V> getEntry(K key) {
//            return hashMap.get(key);
//        }
//
//        /**
//         * 内部类 链表
//         *
//         * @param <K>
//         * @param <V>
//         */
//        class ListNode<K, V> {
//            public ListNode pre;
//            public ListNode next;
//            public K key;
//            public V value;
//        }
//    }
//
//}
//
//
