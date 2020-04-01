package practice.leetcode.easy;

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
public class $387FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static int firstUniqChar(String s) {
        if (s == null) return -1;
        char[] sArr = s.toCharArray();
        int[] words = new int[26];
        for (int i = sArr.length-1;i>=0;i--) {
            words[sArr[i] - 'a']++;
        }
        for (int i=0;i<sArr.length;i++) {
            if (words[sArr[i] - 'a'] == 1) return i;
        }
        return-1;
    }
}
