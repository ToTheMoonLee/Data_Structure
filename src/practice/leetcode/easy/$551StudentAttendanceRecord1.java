package practice.leetcode.easy;

/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class $551StudentAttendanceRecord1 {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord2("PPALLL"));
    }

    /**
     * their concise solution of this problem
     * @param s
     * @return
     */
    static boolean checkRecord2(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static boolean checkRecord(String s) {
        if (s.contains("LLL")) return false;
        int a = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == 'A' && ++a ==2) {
                return false;
            }
        }
        return true;
    }
}
