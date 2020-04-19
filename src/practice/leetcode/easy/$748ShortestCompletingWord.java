package practice.leetcode.easy;

/**
 * Find the minimum length word from a given dictionary words,
 * which has all the letters from the string licensePlate.
 * Such a word is said to complete the given string licensePlate
 *
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 *
 * It is guaranteed an answer exists. If there are multiple answers,
 * return the one that occurs first in the array.
 *
 * The license plate might have the same letter occurring multiple times.
 * For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate,
 * but the word "supper" does.
 *
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */
public class $748ShortestCompletingWord {

    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt",new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(shortestCompletingWord2("1s3 PSt",new String[]{"step", "steps", "stripe", "stepple"}));
    }

    /**
     * their amazing solution of this problem
     */
    static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
    static String shortestCompletingWord2(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
        for(String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                shortest = word;
        return shortest;
    }

    static long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25)
                product *= primes[index];
        }
        return product;
    }

    /**
     * my solution of this problem
     * @param licensePlate
     * @param words
     * @return
     */
    static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] temp = new int[26];
        String s = licensePlate.toLowerCase();
        char[] arr = s.toCharArray();
        int size = 0;
        for (int i=0;i<arr.length;i++) {
            int index = arr[i]-'a';
            if (index >=0 && index<26) {
                temp[index]++;
                size++;
            }
        }
        String min = "aaaaaaaaaaaaaaaa";
        for (int i=0;i<words.length;i++) {
            char[] sArr = words[i].toCharArray();
            int tmp = size;
            int[] temp1 = new int[26];
            for (int k=0;k<temp.length;k++) {
                temp1[k] = temp[k];
            }
            for (int j=0;j<sArr.length;j++) {
                if (temp1[sArr[j]-'a'] >0) {
                    temp1[sArr[j]-'a']--;
                    tmp--;
                }
                if (tmp == 0 && sArr.length<min.length()) {
                    min = new String(sArr);
                }
            }
        }
        return min;
    }
}
