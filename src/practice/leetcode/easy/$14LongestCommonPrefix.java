package practice.leetcode.easy;

public class $14LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(" result is " + longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(" result is " + longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(" result is " + longestCommonPrefix2(new String[]{"flower","flow","flight"}));
        System.out.println(" result is " + longestCommonPrefix2(new String[]{"dog","racecar","car"}));
    }

    static String longestCommonPrefix2(String[] strs) {
        String prefix = "";
        if (strs == null || strs.length == 0) {
            return prefix;
        }
        prefix = strs[0];

        for (int i=1;i<strs.length;i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs == null || strs.length == 0) {
            return prefix;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String pre = strs[0];
        for (int i=1;i<strs.length;i++) {
            int j=0;
            int k=0;
            prefix = "";
            while (j<pre.length() && k<strs[i].length()) {
                if (pre.charAt(j) != strs[i].charAt(k)) {
                    break;
                }
                prefix = prefix + pre.charAt(j);
                j++;
                k++;
            }
            if (prefix.equals("")) {
                return "";
            }
            pre = prefix;
        }
        return prefix;
    }
}
