package practice.leetcode.easy;

import java.util.*;

/**
 * You are given a data structure of employee information,
 * which includes the employee's unique id, his importance value and his direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3.
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 *
 * Now given the employee information of a company,
 * and an employee id, you need to return the total importance value of this employee and all his subordinates.
 *
 * Example 1:
 *
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
 * They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 *
 *
 * Note:
 *
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 */
public class $690EmployeeImportance {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();

        Employee e1 = new Employee(1, 5, l1);
        Employee e2 = new Employee(2, 3, l2);
        Employee e3 = new Employee(3, 3, l3);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        System.out.println(getImportance(employees, 1));
        System.out.println(getImportance2(employees, 1));
    }

    /**
     * their recursive solution of this problem
     */
    static Map<Integer, Employee> emap;
    static int getImportance2(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    static int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

    /**
     * my solution of this problem
     * @param employees
     * @param id
     * @return
     */
    static int getImportance(List<Employee> employees, int id) {
        Queue<Employee> q = new LinkedList<>();
        HashMap<Integer,Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id,e);
            if (e.id == id) {
                q.offer(e);
            }
        }
        int total = 0;
        while (!q.isEmpty()) {
            Employee temp = q.poll();
            total+=temp.importance;
            if (temp.subordinates.size() !=0) {
                for (Integer i : temp.subordinates) q.offer(map.get(i));
            }
        }
        return total;
    }

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}
