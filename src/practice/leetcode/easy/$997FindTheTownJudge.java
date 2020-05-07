package practice.leetcode.easy;

/**
 * In a town, there are N people labelled from 1 to N.
 * There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing
 * that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
public class $997FindTheTownJudge {

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{new int[]{1, 3}, new int[]{2, 3}}));
        System.out.println(findJudge2(3, new int[][]{new int[]{1, 3}, new int[]{2, 3}}));
    }

    /**
     * their solution of this problem
     * @param N
     * @param trust
     * @return
     */
    static int findJudge2(int N, int[][] trust) {
        int[] count = new int[N+1];
        for(int i=0;i<trust.length;i++) {
            count[trust[i][0]]--;
            count[trust[i][1]]++;
        }
        for (int i=1;i<count.length;i++) {
            if (count[i]==N-1) return i;
        }
        return -1;
    }

    /**
     * my solution of this problem
     * @param N
     * @param trust
     * @return
     */
    static int findJudge(int N, int[][] trust) {
        int[] labels = new int[N+1];
        int[] peoples = new int[N+1];
        for(int i=0;i<trust.length;i++) {
            peoples[trust[i][0]]++;
            labels[trust[i][1]]++;
        }
        int judge = 0;
        for (int i=1;i<peoples.length;i++) {
            if (peoples[i] == 0) judge = i;
        }
        for (int i=0;i<labels.length;i++) {
            if (labels[i]==N-1 && judge==i) return i;
        }
        return -1;
    }
}
