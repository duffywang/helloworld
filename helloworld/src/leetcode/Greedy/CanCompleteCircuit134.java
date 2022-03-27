package leetcode.Greedy;

/**
 * @auther : wangyufei
 * @date : 2020-10-18
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 **/
public class CanCompleteCircuit134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, cur = 0, index = 0;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                index = i + 1;
                cur = 0;
            }
        }
        return sum >= 0 ? index : -1;
    }
}
