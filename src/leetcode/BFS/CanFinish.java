package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @auther : wangyufei
 * @date : 2020-11-29
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            for (Integer cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) queue.offer(cur);
            }
        }
        return numCourses == 0;
    }

    //深度优先
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }


    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        boolean res = canFinish(2, prerequisites);
        System.out.println(res);
    }
}
