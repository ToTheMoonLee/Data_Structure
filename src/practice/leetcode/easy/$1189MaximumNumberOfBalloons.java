package practice.leetcode.easy;

/**
 * Given a string text, you want to use the characters
 * of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once.
 * Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 */
public class $1189MaximumNumberOfBalloons {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }

    static int maxNumberOfBalloons(String text) {
        int[] letter = new int[5];
        char[] arr = text.toCharArray();
        for (char c : arr) {
            if (c == 'b') letter[0]++;
            if (c == 'a') letter[1]++;
            if (c == 'l') letter[2]++;
            if (c == 'o') letter[3]++;
            if (c == 'n') letter[4]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<letter.length;i++) {
            if (i == 2 || i==3) {
                ans = Math.min(ans,letter[i]/2);
            } else {
                ans = Math.min(ans,letter[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
