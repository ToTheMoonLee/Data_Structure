package practice.leetcode.easy;

import java.util.HashMap;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
 * if and only if either (a==c and b==d), or (a==d and b==c) - that is,
 * one domino can be rotated to be equal to another domino.
 *
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length,
 * and dominoes[i] is equivalent to dominoes[j].
 *
 *
 *
 * Example 1:
 *
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class $1128NumberOfEquivalentDominoPairs {

    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{new int[]{1, 2}, new int[]{2, 1}, new int[]{3, 4}, new int[]{5, 6}}));
    }

    static int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        for (int value : map.values()) {
            ans += value*(value-1)/2;
        }
        return ans;
    }
}
