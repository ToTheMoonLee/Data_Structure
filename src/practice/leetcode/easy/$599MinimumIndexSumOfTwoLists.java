package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class $599MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};
        PrintUtil.printArr(findRestaurant(list1, list2));
    }

    /**
     * my solution of this problem
     * @param list1
     * @param list2
     * @return
     */
    static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int min = 2001;
        for (int i=0;i<list1.length;i++) {
            map.put(list1[i],i);
        }
        for (int i=0;i<list2.length;i++) {
            Integer index = map.getOrDefault(list2[i],2001);
            if (index != 2001) {
                int sum = index + i;
                if (sum == min) {
                    result.add(list2[i]);
                } else if (sum < min) {
                    min = sum;
                    result.clear();
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
