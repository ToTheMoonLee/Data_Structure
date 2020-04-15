package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of
 * this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class $697DegreeOfAnArray {

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
        System.out.println(findShortestSubArray2(new int[]{1,2,2,3,1}));
    }

    /**
     * their faster solution of this problem
     * @param nums
     * @return
     */
    static int findShortestSubArray2(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            }
        }
        return res;
    }

    /**
     * my first solution of this problem,beats 77%
     * @param nums
     * @return
     */
    static int findShortestSubArray(int[] nums) {
        int[] max = new int[50000];
        int[] pos = new int[100000];
        for (int i=0;i<pos.length;i++) {
            pos[i] = -1;
        }
        for (int i=0;i<nums.length;i++) {
            int k = nums[i];
            max[k]++;
            if (pos[k] == -1) {
                pos[k] = i;
            } else {
                pos[k+50000] = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        int n = 0;
        for (int i=0;i<max.length;i++) {
            int temp = max[i];
            if (temp == 0) continue;
            if (n < temp) {
                list.clear();
                list.add(i);
                n = temp;
            } else if (n == temp) {
                list.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<list.size();i++) {
            int target = list.get(i);
            if (pos[target+50000] == -1) min = 1;
            else min = Math.min(min,pos[target+50000]-pos[target]+1);
        }
        return min;
    }
}
