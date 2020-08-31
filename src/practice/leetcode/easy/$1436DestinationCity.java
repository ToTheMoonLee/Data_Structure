package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * You are given the array paths,
 * where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
 * Return the destination city, that is, the city without any path outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore,
 * there will be exactly one destination city.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
 * Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 * Example 2:
 * <p>
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 * Example 3:
 * <p>
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * All strings consist of lowercase and uppercase English letters and the space character.
 */
public class $1436DestinationCity {

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> firstPath = new ArrayList<>();
        firstPath.add("London");
        firstPath.add("New York");
        List<String> secondPath = new ArrayList<>();
        secondPath.add("New York");
        secondPath.add("Lima");
        List<String> thirdPath = new ArrayList<>();
        thirdPath.add("Lima");
        thirdPath.add("Sao Paulo");
        paths.add(firstPath);
        paths.add(secondPath);
        paths.add(thirdPath);
        System.out.println(destCity(paths));
        System.out.println(destCity2(paths));
    }

    /**
     * their faster solution of this problem
     *
     * @param paths
     * @return
     */
    static String destCity2(List<List<String>> paths) {
        HashSet<String> set = new HashSet();
        String result = "";

        for (int i = 0; i < paths.size(); i++) {
            set.add(paths.get(i).get(0));
        }

        for (int i = 0; i < paths.size(); i++) {
            if (!set.contains(paths.get(i).get(1))) {
                result = paths.get(i).get(1);
                break;
            }
        }

        return result;
    }

    /**
     * my solution of this problem
     *
     * @param paths
     * @return
     */
    static String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<String>();
        List<String> list = new ArrayList<>();
        for (List<String> l : paths) {
            set.add(l.get(0));
            list.add(l.get(1));
        }
        list.removeIf(set::contains);
        return list.get(0);
    }
}
