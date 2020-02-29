package practice.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right)
 * in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class $58LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord2(s));
        System.out.println(lengthOfLastWord3(s));
    }

    /**
     * the others solution of this problem
     * <a href="https://leetcode.com/problems/length-of-last-word/discuss/21927/My-3-line-0-ms-java-solution"/>
     *
     * @param s
     * @return
     */
    static int lengthOfLastWord3(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }

    /**
     * my second solution of this problem
     *
     * @param s
     * @return
     */
    static int lengthOfLastWord2(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int count = 0;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                i--;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * my first solution of this problem
     *
     * @param s
     * @return
     */
    static int lengthOfLastWord(String s) {
        String[] splits = s.split(" ");
        if (splits.length == 0) return 0;
        return splits[splits.length - 1].length();
    }
}
