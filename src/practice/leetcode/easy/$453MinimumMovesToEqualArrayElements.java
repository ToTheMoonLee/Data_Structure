package practice.leetcode.easy;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required
 * to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class $453MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 3}));
    }

    /**
     * their solution of this problem
     * first incrementing n - 1 elements by 1 and then decrementing n elements by 1;
     * @param nums
     * @return
     */
    static int minMoves(int[] nums) {
        int result = 0;
        int min = nums[0];
        for (int i : nums) min = Math.min(min,i);
        for (int i: nums) result+=(i-min);
        return result;

    }
}
