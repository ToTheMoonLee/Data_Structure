package practice.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an integer array with even length,
 * where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind.
 * You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 * Note:
 *
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 */
public class $575DistributeCandies {

    public static void main(String[] args) {
        int[] candies = new int[]{-100000, 0, 100000, 0, 100000, 0, 100000, 0, 100000, 0, 100000, 0};

        System.out.println(distributeCandies(candies));
        System.out.println(distributeCandies2(candies));
        System.out.println(distributeCandies3(candies));
    }

    /**
     * their faster solution of this problem
     * @param candies
     * @return
     */
    static int distributeCandies3(int[] candies) {
        boolean[] b = new boolean[200001];
        int nonEmptyBucketNo = 0;
        for (int i : candies) if (b[i + 100000] == false) {nonEmptyBucketNo++; b[i+100000] = true;}
        return nonEmptyBucketNo <= candies.length / 2 ? nonEmptyBucketNo : candies.length / 2;
    }

    /**
     * my second solution of this problem
     * @param candies
     * @return
     */
    static int distributeCandies2(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<candies.length;i++) {
            set.add(candies[i]);
        }
        return Math.min(set.size(),candies.length/2);
    }

    /**
     * my first solution of this problem
     * @param candies
     * @return
     */
    static int distributeCandies(int[] candies) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<candies.length;i++) {
            map.put(candies[i],map.getOrDefault(candies[i],0)+1);
        }
        return Math.min(map.size(),candies.length/2);
    }
}
