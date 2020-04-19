package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a string S, we can transform every letter individually
 * to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 *
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class $784LetterCasePermutation {

    public static void main(String[] args) {
        PrintUtil.printList(letterCasePermutation("a1b2c3"));
        System.out.println("--------------------------");
        PrintUtil.printList(letterCasePermutation2("a1b2c3"));
    }

    /**
     * their faster and recursive solution of this problem
     * @param S
     * @return
     */
    static List<String> letterCasePermutation2(String S) {
        List<String> ans=new ArrayList<>();
        compute(ans,S.toCharArray(),0);
        return ans;
    }

    static void compute(List<String> list,char[] arr,int index) {
        if (index == arr.length) {
            list.add(new String(arr));
        } else {
            if (Character.isLetter(arr[index])) {
                arr[index] = Character.toLowerCase(arr[index]);
                compute(list,arr,index+1);
                arr[index] = Character.toUpperCase(arr[index]);
            }
            compute(list,arr,index+1);
        }
    }

    /**
     * my solution of this problem
     * @param S
     * @return
     */
    static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        String s = S.toLowerCase();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            String tmp = q.poll();
            list.add(tmp);
            char[] arr = tmp.toCharArray();
            for (int i=arr.length-1;i>=0;i--) {
                char c = arr[i];
                if (isUpper(c)) break;
                if (isLower(c)) {
                    arr[i] = Character.toUpperCase(c);
                    q.offer(new String(arr));
                    arr[i] = c;
                }
            }
        }
        return list;
    }

    static boolean isUpper(char c) {
        int a = c-'A';
        return a>=0&&a<26;
    }

    static boolean isLower(char c) {
        int a = c-'a';
        return a>=0&&a<26;
    }

}
