package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given words first and second, consider occurrences in some text of the form "first second third",
 * where second comes immediately after first, and third comes immediately after second.
 *
 * For each such occurrence, add "third" to the answer, and return the answer.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 * Example 2:
 *
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 *
 *
 * Note:
 *
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 */
public class $1078OccurrencesAfterBigram {

    public static void main(String[] args) {
        PrintUtil.printArr(findOcurrences("we will we will rock you","we","will"));
    }

    /**
     * my implement of this problem
     * @param text
     * @param first
     * @param second
     * @return
     */
    static String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        int i=0;
        String cur = first;
        List<String> ans = new ArrayList<>();
        while (i<arr.length) {
            if (i>1 && arr[i-2].equals(first) && arr[i-1].equals(second)) {
                ans.add(arr[i]);
            }
            i++;
        }
        return ans.toArray(new String[0]);
    }
}
