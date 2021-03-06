package practice.leetcode.easy;

/**
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess,
 * you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position (called "bulls")
 * and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits,
 * and their lengths are always equal.
 */
public class $299BullsAndCows {

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";

        System.out.println(getHint(secret,guess));
        System.out.println(getHint2(secret,guess));
    }

    /**
     * their solution of this problem
     * @param secret
     * @param guess
     * @return
     */
    static String getHint2(String secret, String guess) {
        int[] cache = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i=0;i<secret.length();i++) {
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if (s == g) {
                bulls++;
            } else {
                if (cache[s] >0) cows++;
                if (cache[g] < 0) cows++;
                cache[s]--;
                cache[g]++;
            }
        }
        return bulls+"A"+cows+"B";
    }

    /**
     * my solution of this problem
     * @param secret
     * @param guess
     * @return
     */
    static String getHint(String secret, String guess) {
        int[] cache = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i=0;i<secret.length();i++) {
            cache[secret.charAt(i)-'0']++;
        }
        for (int i=0;i<secret.length();i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                cache[secret.charAt(i)-'0']--;
            }
        }
        for (int i=0;i<secret.length();i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }
            if (cache[guess.charAt(i)-'0']-- > 0) {
                cows++;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
