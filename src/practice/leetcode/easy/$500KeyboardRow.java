package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed
 * using letters of alphabet on only one row's of American keyboard like the image below.
 *
 *
 *
 *
 *
 *
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */
public class $500KeyboardRow {

    public static void main(String[] args) {
        PrintUtil.printArr(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }

    /**
     * my solution of this problem
     * @param words
     * @return
     */
    static String[] findWords(String[] words) {
        int[] d1 = new int[26];
        int[] d2 = new int[26];
        int[] d3 = new int[26];
        String row1="qwertyuiuop",
                row2="asdfghjkl",
                row3="zxcvbnm";
        List<String> result = new ArrayList<>();
        for (int i=0;i<row1.length();i++) {
            d1[row1.charAt(i)-'a'] = 1;
            if (i<row2.length()) {
                d2[row2.charAt(i)-'a'] = 1;
            }
            if (i<row3.length()) {
                d3[row3.charAt(i)-'a'] = 1;
            }
        }
        for (int i=0;i<words.length;i++) {
            String temp = words[i];
            if (temp.length() == 0) continue;
            if (d1[Character.toLowerCase(temp.charAt(0))-'a']==1) {
                if (isRow(temp,d1)) {
                    result.add(temp);
                }
            } else if (d2[Character.toLowerCase(temp.charAt(0))-'a']==1) {
                if (isRow(temp,d2)) {
                    result.add(temp);
                }
            } else {
                if (isRow(temp,d3)) {
                    result.add(temp);
                }
            }

        }
        String[] res=new String[result.size()];
        return result.toArray(res);
    }
    private static boolean isRow(String s,int[] dic) {
        if (s.length()==0) return false;
        for (int i=0;i<s.length();i++) {
            if (dic[Character.toLowerCase(s.charAt(i))-'a'] !=1) {
                return false;
            }
        }
        return true;
    }
}
