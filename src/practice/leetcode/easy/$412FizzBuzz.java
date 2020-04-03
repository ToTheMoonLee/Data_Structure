package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number
 * and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
public class $412FizzBuzz {

    public static void main(String[] args) {
        PrintUtil.printList(fizzBuzz(15));
        System.out.println();
        System.out.println("-------------------");
        System.out.println();
        PrintUtil.printList(fizzBuzz2(15));
    }

    /**
     * my second solution of this problem
     * @param n
     * @return
     */
    static List<String> fizzBuzz2(int n) {
        String[] arr = new String[n];
        for (int i=1;i<=n;i++) {
            if (i%3 == 0 && i%5==0) arr[i-1] = "FizzBuzz";
            else if (i%3 == 0) arr[i-1] = "Fizz";
            else if (i%5 == 0) arr[i-1] = "Buzz";
            else arr[i-1] = String.valueOf(i);
        }
        return Arrays.asList(arr) ;
    }

    /**
     * my solution of this problem
     * @param n
     * @return
     */
    static List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            if (i%3 == 0 && i%5==0) list.add("FizzBuzz");
            else if (i%3 == 0) list.add("Fizz");
            else if (i%5 == 0) list.add("Buzz");
            else list.add(i+"");
        }
        return list;
    }
}
