package leetcode.BFS;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;

import java.util.*;

/**
 * @auther : wangyufei
 * @date : 2020-11-21
 * <p>
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * <p>
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * <p>
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        int count = 0;
        Employee boss = new Employee();
        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees) {
            if (employee.id == id) {
                boss = employee;
            }
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList();
        queue.offer(boss);
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            count += employee.importance;
            if (employee.subordinates.size() != 0) {
                for (Integer subEmployee : employee.subordinates) {
                    queue.offer(map.get(subEmployee));
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        GetImportance task = new GetImportance();
        ArrayList<Integer> list1 = Lists.newArrayList(2, 3);
        Employee employee1 = new Employee(1, 5, list1);
        Employee employee2 = new Employee(2, 3, Lists.newArrayList());
        Employee employee3 = new Employee(3, 3, Lists.newArrayList());
        ArrayList<Employee> employees = Lists.newArrayList(employee1, employee2, employee3);
        int res = task.getImportance(employees, 1);
        System.out.println(res);
    }


    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public int getId() {
            return id;
        }

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public Employee() {
        }


        public void setId(int id) {
            this.id = id;
        }

        public int getImportance() {
            return importance;
        }

        public void setImportance(int importance) {
            this.importance = importance;
        }

        public List<Integer> getSubordinates() {
            return subordinates;
        }

        public void setSubordinates(List<Integer> subordinates) {
            this.subordinates = subordinates;
        }
    }

    ;
}
