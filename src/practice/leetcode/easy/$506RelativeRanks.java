package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class $506RelativeRanks {

    public static void main(String[] args) {
        PrintUtil.printArr(findRelativeRanks(new int[]{4,3,1,5,2}));
        System.out.println("-------------------");
        PrintUtil.printArr(findRelativeRanks2(new int[]{4,3,1,5,2}));
        System.out.println("-------------------");
        PrintUtil.printArr(findRelativeRanks3(new int[]{4,3,1,5,2}));
    }

    /**
     * their faster solution of this problem,but need very large extra space
     * @param nums
     * @return
     */
    static String[] findRelativeRanks3(int[] nums) {
        String[] result = new String[nums.length];
        int max = 0;
        for (int i : nums) {
            if (i > max) max = i;
        }
        int[] hash = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i + 1;
        }
        int place = 1;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (place == 1) {
                    result[hash[i] - 1] = "Gold Medal";
                } else if (place == 2) {
                    result[hash[i] - 1] = "Silver Medal";
                } else if (place == 3) {
                    result[hash[i] - 1] = "Bronze Medal";
                } else {
                    result[hash[i] - 1] = String.valueOf(place);
                }
                place++;
            }
        }
        return result;
    }

    /**
     * my second solution of this problem,slower than my first solution
     * @param nums
     * @return
     */
    static String[] findRelativeRanks2(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        HashMap<Integer,String> map = new HashMap<>();
        for (int a=temp.length-1;a>=0;a--) {
            if (a == temp.length-1) map.put(temp[a],"Gold Medal");
            else if (a == temp.length-2) map.put(temp[a],"Silver Medal");
            else if (a == temp.length-3) map.put(temp[a],"Bronze Medal");
            else map.put(temp[a],String.valueOf(temp.length-a));
        }

        String[] result = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }

    /**
     * my first solution of this problem,faster than 50% solution
     * @param nums
     * @return
     */
    static String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i=0;i<nums.length;i++) {
            priorityQueue.add(nums[i]);
        }
        HashMap<Integer,String> map = new HashMap<>();
        int a = 1;
        while (!priorityQueue.isEmpty()) {
            if (a == 1) map.put(priorityQueue.poll(),"Gold Medal");
            else if (a == 2) map.put(priorityQueue.poll(),"Silver Medal");
            else if (a == 3) map.put(priorityQueue.poll(),"Bronze Medal");
            else map.put(priorityQueue.poll(),String.valueOf(a));
            a++;
        }

        String[] result = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }

}
