package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 *
 * We then give 1 candy to the first person, 2 candies to the second person,
 * and so on until we give n candies to the last person.
 *
 * Then, we go back to the start of the row, giving n + 1 candies to the first person,
 * n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
 *
 * This process repeats (with us giving one more candy each time,
 * and moving to the start of the row after we reach the end) until we run out of candies.
 * The last person will receive all of our remaining candies
 * (not necessarily one more than the previous gift).
 *
 * Return an array (of length num_people and sum candies)
 * that represents the final distribution of candies.
 *
 *
 *
 * Example 1:
 *
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left),
 * and the final array is [1,2,3,1].
 * Example 2:
 *
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 *
 *
 * Constraints:
 *
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 */
public class $1103DistributeCandiesToPeople {

    public static void main(String[] args) {
        PrintUtil.printArr(distributeCandies(7,4));
        PrintUtil.printArr(distributeCandies2(7,4));
    }

    /**
     * their concise solution of this problem
     * @param candies
     * @param num_people
     * @return
     */
    static int[] distributeCandies3(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] +=  Math.min(candies, ++give);
        }
        return people;
    }

    /**
     * my faster solution of this problem
     * @param candies
     * @param num_people
     * @return
     */
    static int[] distributeCandies2(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i=0;
        for (;i<candies;i++) {
            ans[i%num_people] = ans[i%num_people] + i+1;
            candies = candies -i-1;
        }
        ans[i%num_people] += candies;
        return ans;
    }

    /**
     * my first solution of this problem
     * @param candies
     * @param num_people
     * @return
     */
    static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int total = 0;
        int i=0;
        for (;i<candies-total;i++) {
            ans[i%num_people] = ans[i%num_people] + i+1;
            total = total + i+1;
        }
        ans[i%num_people] = ans[i%num_people] + candies-total;
        return ans;
    }
}
