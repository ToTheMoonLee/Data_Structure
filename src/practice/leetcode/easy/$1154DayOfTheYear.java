package practice.leetcode.easy;

/**
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD,
 * return the day number of the year.
 *
 *
 *
 * Example 1:
 *
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 * Example 2:
 *
 * Input: date = "2019-02-10"
 * Output: 41
 * Example 3:
 *
 * Input: date = "2003-03-01"
 * Output: 60
 * Example 4:
 *
 * Input: date = "2004-03-01"
 * Output: 61
 *
 *
 * Constraints:
 *
 * date.length == 10
 * date[4] == date[7] == '-', and all other date[i]'s are digits
 * date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
 */
public class $1154DayOfTheYear {

    public static void main(String[] args) {
        System.out.println(dayOfYear("2003-03-01"));
    }

    static int[] months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int[] months2 = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
    static int dayOfYear(String date) {
        int ans = 0;
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int days = Integer.parseInt(arr[2]);

        for (int i=month-1;i>0;i--) {
            if (year%4 == 0 && year%100!=0 || year%400 == 0) {
                ans += months2[i];
            } else {
                ans += months[i];
            }
        }
        return ans + days;
    }
}
