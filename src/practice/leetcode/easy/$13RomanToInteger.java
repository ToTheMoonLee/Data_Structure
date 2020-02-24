package practice.leetcode.easy;

import java.util.HashMap;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral,
 * just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class $13RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println("result is " + romanToInt(s));
        System.out.println("result is " + romanToInt2(s));
        System.out.println("result is " + romanToInt3(s));
    }

    /**
     * the amazing version of others
     * <a href="https://leetcode.com/problems/roman-to-integer/discuss/6529/My-solution-for-this-question-but-I-don't-know-is-there-any-easier-way">
     * @param s
     * @return
     */
    static int romanToInt3(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    result += (result >= 5) ? -1 : 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += (result >= 50) ? -10 : 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += (result >= 500) ? -100 : 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    /**
     * the amazing version of others
     * <a href="https://leetcode.com/problems/roman-to-integer/discuss/6529/My-solution-for-this-question-but-I-don't-know-is-there-any-easier-way">
     * @param s
     * @return
     */
    static int romanToInt2(String s) {
        int sum = 0;
        if (s.contains("IV") || s.contains("IX")) {
            sum -= 2;
        }
        if (s.contains("XL") || s.contains("XC")) {
            sum -= 20;
        }
        if (s.contains("CD") || s.contains("CM")) {
            sum -= 200;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;

            }
        }
        return sum;
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        hash.put('I',1);
        hash.put('V',5);
        hash.put('X',10);
        hash.put('L',50);
        hash.put('C',100);
        hash.put('D',500);
        hash.put('M',1000);

        int result = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if ((i+1)<s.length()) {
                char c1 = s.charAt(i+1);
                if (c == 'C' && c1 == 'D') {
                    result += 400;
                    i++;
                    continue;
                }
                if (c == 'C' && c1 == 'M') {
                    result += 900;
                    i++;
                    continue;
                }
                if (c == 'X' && c1 == 'L') {
                    result += 40;
                    i++;
                    continue;
                }
                if (c == 'X' && c1 == 'C') {
                    result += 90;
                    i++;
                    continue;
                }
                if (c == 'I' && c1 == 'V') {
                    result += 4;
                    i++;
                    continue;
                }
                if (c == 'I' && c1 == 'X') {
                    result += 9;
                    i++;
                    continue;
                }
            }
            result += hash.get(c);
        }
        return result;
    }
}
