package practice.leetcode.easy;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated
 * such that B is a substring of it. If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”),
 * B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class $686RepeatedStringMatch {

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd","cdabcdab"));
    }

    /**
     * my solution of this problem
     * @param A
     * @param B
     * @return
     */
    static int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder a = new StringBuilder(A);
        while (a.length() < B.length()) {
            a.append(A);
            count++;
        }
        if (a.toString().contains(B)) return count;
        if (a.append(A).toString().contains(B)) return count+1;
        return -1;
    }
}
