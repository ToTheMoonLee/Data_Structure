package practice.leetcode.easy;

/**
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.
 * Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation.
 * 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other
 * (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored);
 * 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */
public class $788RotatedDigits {

    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
        System.out.println(rotatedDigits2(10));
    }

    /**
     * their dp and concise solution of this problem
     * @param N
     * @return
     */
    static int rotatedDigits2(int N) {
        int[] dp = new int[N+1];
        int count = 0;
        for (int i= 0;i<=N;i++) {
            if (i<10) {
                if (i==0 || i==1 || i==8) dp[i] = 1;
                else if (i==2 || i==5 || i==6 || i==9) {
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i/10];
                int b = dp[i%10];
                if (a == 1 && b==1) dp[i]=1;
                else if (a>=1 && b>=1) {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * my solution of this problem
     * @param N
     * @return
     */
    static int rotatedDigits(int N) {
        int result = 0;
        for (int i= 1;i<=N;i++) {
            if (isGood(i)) result++;
        }
        return result;
    }

    static boolean isGood(int N) {
        boolean result = false;
        while (N!=0) {
            int temp = N%10;
            if (temp == 3 || temp == 4 || temp == 7) return false;
            if (temp == 2 || temp == 5 || temp == 6 || temp == 9) result = true;
            N/=10;
        }
        return result;
    }
}
