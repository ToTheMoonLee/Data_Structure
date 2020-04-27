package practice.leetcode.easy;

/**
 * Your friend is typing his name into a keyboard.
 * Sometimes, when typing a character c,
 * the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.
 * Return True if it is possible that it was your friends name,
 * with some characters (possibly none) being long pressed.
 *
 *
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 *
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 *
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 *
 * Constraints:
 *
 * 1 <= name.length <= 1000
 * 1 <= typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class $925LongPressedName {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("leelee","lleeelee"));
        System.out.println(isLongPressedName2("leelee","lleeelee"));
    }


    static boolean isLongPressedName2(String name, String typed) {
        char[] nameArr = name.toCharArray();
        char[] typedArr = typed.toCharArray();
        int j=0;
        for (int i=0;i<typedArr.length;i++) {
            if (j<nameArr.length && nameArr[j] == typedArr[i]) j++;
            else if (i==0 || typedArr[i] != typedArr[i-1]) return false;
        }
        return j==nameArr.length;
    }

    /**
     * my solution of this problem
     * @param name
     * @param typed
     * @return
     */
    static boolean isLongPressedName(String name, String typed) {
        char[] nameArr = name.toCharArray();
        char[] typedArr = typed.toCharArray();
        int k=0,l=0;
        for (int i=0,j=0;i<nameArr.length && j<typedArr.length;i=k,j=l) {
            if (nameArr[i]!=typedArr[j]) return false;
            int count1 = 1,count2 = 1;
            for (k=i+1;k<nameArr.length&&nameArr[k]==nameArr[i];k++) {
                count1++;
            }
            for (l=j+1;l<typedArr.length&&typedArr[l]==typedArr[j];l++){
                count2++;
            }
            if (count2<count1) return false;
        }
        return k==nameArr.length&&l==typedArr.length;
    }
}
