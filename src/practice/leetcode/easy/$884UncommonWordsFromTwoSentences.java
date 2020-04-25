package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.*;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.
 * Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class $884UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        PrintUtil.printArr(uncommonFromSentences(A,B));
        System.out.println("------------------------");
        PrintUtil.printArr(uncommonFromSentences2(A,B));
        System.out.println("------------------------");
        PrintUtil.printArr(uncommonFromSentences3(A,B));
    }

    /**
     * this solution seems faster
     * @param A
     * @param B
     * @return
     */
    static String[] uncommonFromSentences3(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }

    /**
     * my second solution of this problem
     * @param A
     * @param B
     * @return
     */
    static String[] uncommonFromSentences2(String A, String B) {
        String[] arr = (A+" " + B).split(" ");
        HashSet<String> set = new HashSet<>();
        HashSet<String> list = new HashSet<>();
        for (String s : arr) {
            if (set.add(s)) {
                list.add(s);
            } else {
                if (list.contains(s)) list.remove(s);
            }
        }
        return list.toArray(new String[0]);
    }

    /**
     * my first solution of this problem
     * @param A
     * @param B
     * @return
     */
    static String[] uncommonFromSentences(String A, String B) {
        String[] arr = (A+" " + B).split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) list.add(s);
        }
        return list.toArray(new String[0]);
    }
}
