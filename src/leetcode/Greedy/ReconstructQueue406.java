package leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @auther : wangyufei
 * @date : 2020-10-18
 * <p>
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ReconstructQueue406 {
    public static int[][] reconstructQueue(int[][] people) {
        //身高由高向低降序排序，身高相同，按前面人数升序排序，优先处理身高高的，使用LinkedList数据结构
        // 这样后续插入矮个子对后排高个儿是没有影响的：
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0] == 0 ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        int len = people.length;
        return list.toArray(new int[len][2]);

    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);

    }
}
