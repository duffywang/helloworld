package leetcode.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @auther : wangyufei
 * @date : 2020-12-06
 * 这里有 n 门不同的在线课程，他们按从 1 到 n 编号。每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。一门课要持续学习 t 天直到第 d 天时要完成，你将会从第 1 天开始。
 * <p>
 * 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。
 * 输入: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出: 3
 * 解释:
 * 这里一共有 4 门课程, 但是你最多可以修 3 门:
 * 首先, 修第一门课时, 它要耗费 100 天，你会在第 100 天完成, 在第 101 天准备下门课。
 * 第二, 修第三门课时, 它会耗费 1000 天，所以你将在第 1100 天的时候完成它, 以及在第 1101 天开始准备下门课程。
 * 第三, 修第二门课时, 它会耗时 200 天，所以你将会在第 1300 天时完成它。
 * 第四门课现在不能修，因为你将会在第 3300 天完成它，这已经超出了关闭日期。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ScheduleCourse {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        //倒序，由大到小
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int time = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                queue.offer(course[0]);
                time += course[0];
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                //课程时间太长了，换一个短一点的，贪心思想
                time += course[0] - queue.poll();
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3300}};
        int res = scheduleCourse(courses);
        System.out.println(res);
    }
}
