package practice.leetcode.easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume the given string consists
 * of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class $459RepeatedSubstringPattern {

    public static void main(String[] args) {
        String str = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(str));
        System.out.println(repeatedSubstringPattern2(str));
        System.out.println(repeatedSubstringPattern3(str));
        System.out.println(repeatedSubstringPattern4(str));
    }

    /**
     * their kmp solution of this problem,just like find the substring
     * @param str
     * @return
     */
    static boolean repeatedSubstringPattern4(String str) {
        //This is the kmp issue
        int[] prefix = kmp(str);
        int len = prefix[str.length()-1];
        int n = str.length();
        return (len > 0 && n%(n-len) == 0);
    }
    static int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }

    /**
     * their two lines solution of this problem
     * @param str
     * @return
     */
    static boolean repeatedSubstringPattern3(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    /**
     * their solution of this problem
     * @param str
     * @return
     */
    static boolean repeatedSubstringPattern2(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static boolean repeatedSubstringPattern(String s) {
        for(int i=s.length()/2;i>0;i--) {
            if (s.length()%i != 0) continue;
            boolean b = true;
            for (int j=0;j+i<s.length();j++) {
                if (s.charAt(j)!=s.charAt(j+i)) b = false;
            }
            if (b) return b;
        }
        return false;
    }
}
