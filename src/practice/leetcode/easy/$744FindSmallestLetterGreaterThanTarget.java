package practice.leetcode.easy;

/**
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that is larger than the given target.
 *
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'],
 * the answer is 'a'.
 *
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class $744FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = new char[]{'c','f','j'};
        char target = 'k';
        System.out.println(nextGreatestLetter(letters,target));
        System.out.println(nextGreatestLetter2(letters,target));
    }

    /**
     * their binary solution of this problem
     * @param letters
     * @param target
     * @return
     */
    static char nextGreatestLetter2(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }

    /**
     * my solution of this problem
     * @param letters
     * @param target
     * @return
     */
    static char nextGreatestLetter(char[] letters, char target) {
        boolean[] set = new boolean[26];
        for (char a : letters) {
            set[a-'a'] = true;
        }
        int i = (target-'a'+1)%26;
        while (true) {
            if (set[i]) break;
            i++;
            i%=26;
        }
        return (char)(i+'a');
    }
}
