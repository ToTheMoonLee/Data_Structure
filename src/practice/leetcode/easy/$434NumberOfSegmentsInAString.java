package practice.leetcode.easy;

/**
 * Count the number of segments in a string,
 * where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class $434NumberOfSegmentsInAString {

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }

    /**
     * their solution of this problem
     * @param s
     * @return
     */
    static int countSegments(String s) {
        int count = 0;
        for (int i=0;i<s.length();i++) {
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                count++;
        }
        return count;
    }
}
