package practice.leetcode.easy;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 */
public class $520DetectCapital {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse2("Google"));
    }

    /**
     * their solution of this problem
     * @param word
     * @return
     */
    static boolean detectCapitalUse2(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }

    /**
     * my solution of this problem
     * @param word
     * @return
     */
    static boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int n=0;
        for (int i=0;i<chars.length;i++) {
            n = n<<1;
            int mask = 0;
            if (chars[i]< 65 || chars[i] >90) {
                mask = 0;
            } else {
                mask = 1;
            }
            n = n|mask;
        }
        return (n==0 || n == Math.pow(2,word.length()-1) || n == (Math.pow(2,word.length())-1));
    }
}
