package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters,
 * return a list of all characters that show up in all strings within the list (including duplicates).
 * For example, if a character occurs 3 times in all strings but not 4 times, you need to include
 * that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */
public class $1002FindCommonCharacters {

    public static void main(String[] args) {
        PrintUtil.printList(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println("--------------------------------");
        PrintUtil.printList(commonChars2(new String[]{"bella", "label", "roller"}));
    }

    /**
     * their faster solution of this problem
     * @param A
     * @return
     */
    static List<String> commonChars2(String[] A) {

        List<String> list = new ArrayList<>();
        int[][] charArray = new int[A.length][128];
        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                charArray[i][c]++;

            }
        }

        for (int j = 0; j < charArray[0].length; j++) {
            if (charArray[0][j] > 0) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < charArray.length; k++) {

                    if (charArray[k][j] < min) {
                        min = charArray[k][j];
                    }
                }
                for (int k = 0; k < min; k++) {
                    list.add(Character.toString((char) j));
                }
            }
        }
        return list;
    }

    /**
     * my solution of this problem
     * @param A
     * @return
     */
    static List<String> commonChars(String[] A) {
        int size = A.length;
        int[] letters = new int[26 * size];
        for (int i = 0; i < size; i++) {
            char[] arr = A[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                letters[(arr[j] - 'a') + 26 * i]++;
            }
        }
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < 26) {
            for (int j = i; j < letters.length; j += 26) {
                if (letters[j] == 0) {
                    i++;
                    break;
                }
                letters[j]--;
                if (j + 26 >= letters.length) ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
