package leetcode.Graph;

/**
 * @auther : wangyufei
 * @date : 2022-02-18
 * <p>
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 * <p>
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。
 * 请你找出并返回 edges 所表示星型图的中心节点。
 * <p>
 * 输入：edges = [[1,2],[2,3],[4,2]]
 * 输出：2
 * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-center-of-star-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindCenter1791 {
    public int findCenter(int[][] edges) {
        int len = edges.length;
        int[] array = new int[len + 2];
        for (int i = 0; i < len; i++) {
            array[edges[i][0]]++;
            array[edges[i][1]]++;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == len) return i;

        }
        return 0;

    }
}
