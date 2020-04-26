package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array A of strings.
 *
 * A move onto S consists of swapping any two even indexed characters of S, or any two odd indexed characters of S.
 *
 * Two strings S and T are special-equivalent if after any number of moves onto S, S == T.
 *
 * For example, S = "zzxy" and T = "xyzz" are special-equivalent
 * because we may make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], then S[1] and S[3].
 *
 * Now, a group of special-equivalent strings from A is a non-empty subset of A such that:
 *
 * Every pair of strings in the group are special equivalent, and;
 * The group is the largest size possible
 * (ie., there isn't a string S not in the group such that S is special equivalent to every string in the group)
 * Return the number of groups of special-equivalent strings from A.
 *
 *
 * Example 1:
 *
 * Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
 * Output: 3
 * Explanation:
 * One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent,
 * and none of the other strings are all pairwise special equivalent to these.
 *
 * The other two groups are ["xyzz", "zzxy"] and ["zzyx"].
 * Note that in particular, "zzxy" is not special equivalent to "zzyx".
 * Example 2:
 *
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 */
public class $893GroupsOfSpecialEquivalentStrings {

    public static void main(String[] args) {
        String[] A = new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
        System.out.println(numSpecialEquivGroups(A));
        System.out.println(numSpecialEquivGroups2(A));
    }

    /**
     * their concise solution of this problem,but slower
     * @param A
     * @return
     */
    static int numSpecialEquivGroups2(String[] A) {
        Set<String> set= new HashSet<>();
        for (String s: A){
            int[] odd= new int[26];
            int[] even= new int[26];
            for (int i=0; i<s.length(); i++){
                if (i%2==1) odd[s.charAt(i)-'a']++;
                else even[s.charAt(i)-'a']++;
            }
            String sig= Arrays.toString(odd)+Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }

    /**
     * my solution of this problem
     * @param A
     * @return
     */
    static int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for (String s : A) {
            set.add(getEquiv(s));
        }
        return set.size();
    }
    static String getEquiv(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int[] odds = new int[n%2==0 ? n/2 : n/2+1];
        int[] evens = new int[n/2];
        for (int i=0;i<c.length;i+=2) {
            odds[i/2] = c[i];
        }
        for (int i=1;i<c.length;i+=2) {
            evens[i/2] = c[i];
        }
        Arrays.sort(odds);
        Arrays.sort(evens);
        for (int i=0;i<odds.length;i++) {
            c[i*2] = (char)odds[i];
        }
        for (int i=0;i<evens.length;i++) {
            c[1+i*2] = (char)evens[i];
        }
        return String.valueOf(c);
    }

}
