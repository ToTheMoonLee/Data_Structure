package practice.leetcode.easy;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class $383RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    /**
     * my solution of this problem
     * @param ransomNote
     * @param magazine
     * @return
     */
    static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null) return true;
        if (magazine == null) return false;
        char[] noteArr = ransomNote.toCharArray();
        char[] mArr = magazine.toCharArray();
        int[] words = new int[26];
        for (int i=0;i<mArr.length;i++) {
            words[mArr[i]-'a']++;
        }
        for (int i=0;i<noteArr.length;i++) {
            if (--words[noteArr[i]-'a'] <0) return false;
        }
        return true;
    }
}
