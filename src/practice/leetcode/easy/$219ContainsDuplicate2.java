package practice.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class $219ContainsDuplicate2 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 1));
    }

    /**
     * their solution of this problem
     * using a sliding window int the iterate
     * @param nums
     * @param k
     * @return
     */
    static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    /**
     * my solution of this problem
     * @param nums
     * @param k
     * @return
     */
    static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (hashMap.get(nums[i]) != null) {
                if (i - hashMap.get(nums[i]) <= k) return true;
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }
}
