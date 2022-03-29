package leetcode.Greedy;

/**
 * @auther : wangyufei
 * @date : 2022-03-05
 * <p>
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 * 输入：{'A', 'A', 'A', 'B', 'B', 'B'} n = 2
 * A B -
 * A B -
 * A B
 * 输出：8
 * <p>
 * 输入：["A","A","A","A","A","A","B","C","D","E","F","G"] n = 2
 * A B C
 * A C E
 * A F G
 * A - -
 * A - -
 * A
 * 输出：16
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeastInterval621 {
    public static int leastInterval(char[] tasks, int n) {
        int[] array = new int[26];
        int len = tasks.length;
        int maxTask = 0;
        int maxTaskCount = 0;
        for (char task : tasks) {
            array[task - 'A']++;
            maxTask = Math.max(maxTask, array[task - 'A']);
        }
        for (int i : array) {
            if (i == maxTask) maxTaskCount++;
        }

        return Math.max(len, (maxTask - 1) * (n + 1) + maxTaskCount);

    }

    public static void main(String[] args) {
        char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(task, 2));
    }
}
