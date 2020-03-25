package practice.leetcode.easy;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class $204CountPrimes {

    public static void main(String[] args) {
        int i = countPrimes(10);
        System.out.println(i);
    }

    /**
     * their solution of this problem
     * @param n
     * @return
     */
    static int countPrimes(int n) {
        boolean[] b = new boolean[n];
        int count = 0;
        for (int i=2;i<n;i++) {
            if (!b[i]) {
                count++;
                for (int j=2;i*j<n;j++) {
                    b[i*j] = true;
                }
            }
        }
        return count;
    }

}
