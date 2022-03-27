package leetcode.MultiMerge;

import java.util.*;

/**
 * @auther : wangyufei
 * @date : 2022-01-14
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class KSmallestPairs373 {

    /*一般问题可以解决，但是对于大数据超出内存限制*/
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums1[o1[1]] - (nums2[o2[0]] + nums2[o2[1]]);
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                res.add(list);
            }
            if (res.size() > k * k) break;
        }
        res.sort((o1, o2) -> o1.get(0) + o1.get(1) - (o2.get(0) + o2.get(1)));

        res = res.subList(0, k > nums1.length * nums2.length ? nums1.length * nums2.length : k);

        return res;
    }

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        //pq[0]是num1的下标，pq[1]是num2的下标
        //优先级队列有小到大排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));

        //先把所有nums1的索引入队，即入队元素为[0,0][1,0][2,0]....
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{i, 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        //进行k轮
        while (k-- > 0 && !pq.isEmpty()) {
            //首次弹出的肯定是[0,0]，再次弹出的是[0,1](需要添加)或者[1,0]中弹出较小者
            int[] pos = pq.poll();
            res.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));
            if (++pos[1] < nums2.length) {
                //第一位不动，第二位+1
                pq.offer(pos);
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] num1 = {1, 7, 8};
        int[] num2 = {2, 4, 6};
        List<List<Integer>> res = kSmallestPairs2(num1, num2, 3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).get(0) + ":" + res.get(i).get(1));
        }
    }

}
