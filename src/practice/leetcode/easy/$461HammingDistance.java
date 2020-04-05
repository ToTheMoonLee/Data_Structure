package practice.leetcode.easy;

/**
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class $461HammingDistance {

    /**
     * we can also use the countOne() solution to solve this problem.
     * first we should do like this : x^y,then we just count the one bit in the result
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(hammingDistance(0, 4));
    }

    /**
     * my solution of this problem
     * @param x
     * @param y
     * @return
     */
    static int hammingDistance(int x, int y) {
        int result = 0;
        while (x!=0 || y!=0) {
            int i = (x & 1) ^ (y & 1);
            if ( i== 1) result++;
            x=x>>1;
            y=y>>1;
        }
        return result;
    }
}
