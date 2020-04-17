package practice.leetcode.easy;

/**
 * We have two special characters. The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 *
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 *
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character.
 * So the last character is NOT one-bit character.
 * Note:
 *
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 */
public class $717OneBitAndTwoBitCharacters {

    public static void main(String[] args) {
        int[] ints = {0,1,1,1,0};
        System.out.println(isOneBitCharacter(ints));
        System.out.println(isOneBitCharacter2(ints));
    }

    /**
     * their elegant solution of this problem
     * @param bits
     * @return
     */
    static boolean isOneBitCharacter2(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    /**
     * my solution of this problem
     * @param bits
     * @return
     */
    static boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) return true;
        if (bits.length == 2) return bits[0] != 1;
        if (bits[bits.length-2] == 0) return true;
        int i=0;
        while (i<bits.length-1) {
            if (bits[i] == 1) i+=2;
            else i++;
        }
        return i==bits.length-1;
    }
}
