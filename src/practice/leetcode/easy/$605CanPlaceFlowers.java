package practice.leetcode.easy;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
public class $605CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed,1));
        System.out.println(canPlaceFlowers2(flowerbed,1));
    }

    /**
     * their greedy solution of this problem
     * @param flowerbed
     * @param n
     * @return
     */
    static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if (n == 0) return true;
        int count = 0;
        for (int i=0;i<flowerbed.length;i++) {
            if (flowerbed[i] == 1) {
                i++;
            } else {
                int next = i== flowerbed.length-1 ? 0 : flowerbed[i+1];
                int pre = i==0 ? 0:flowerbed[i-1];
                if (next == 0 && pre == 0) {
                    count++;
                    if (count == n) return true;
                    i++;
                }
            }
        }
        return false;
    }

    /**
     * my solution of this problem
     * @param flowerbed
     * @param n
     * @return
     */
    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int empty = 0;
        int count = 0;
        boolean isFirst = true;
        for (int aFlowerbed : flowerbed) {
            if (aFlowerbed == 0) {
                empty++;
            } else {
                if (isFirst) {
                    count += empty / 2;
                    isFirst = false;
                } else {
                    count += (empty - 1) / 2;
                }
                empty = 0;
            }
        }
        count += isFirst ? (empty+1)/2 : empty/2;
        return count>=n;
    }
}
