package practice.leetcode.easy;

import java.util.Arrays;

public class $581ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {

    }

    /**
     * their amazing solution of this problem
     * @param A
     * @return
     */
    static int findUnsortedSubarray4(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }

    /**
     * their first solution of this problem
     * @param nums
     * @return
     */
    static int findUnsortedSubarray3(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int start = 0;
        while (start < n  && nums[start] == temp[start]) start++;

        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;

        return end - start + 1;
    }

    /**
     * my second solution of this problem,beat 100%
     * @param nums
     * @return
     */
    static int findUnsortedSubarray2(int[] nums) {
        int i=0;
        int start =nums.length-1;
        int end = 0;
        int target = Integer.MAX_VALUE;
        while (i<nums.length-1) {
            if (nums[i]>nums[i+1]) {
                start = i;
                break;
            }
            i++;
        }
        if (start == nums.length-1) return 0;
        while (i<nums.length) {
            if (target > nums[i]) target = nums[i];
            i++;
        }
        start = find(nums,0,start,target,true);
        i = nums.length-1;
        target = Integer.MIN_VALUE;
        while (i>0) {
            if (nums[i] < nums[i-1]) {
                end = i;
                break;
            }
            i--;
        }
        while (i>=0) {
            if (target < nums[i]) target = nums[i];
            i--;
        }
        end = find(nums,end,nums.length-1,target,false);
        return end -start+1;

    }
    static int find(int[] nums,int start,int end,int target,boolean isMax) {
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                if (isMax) {
                    while (mid<nums.length-1) {
                        if (nums[mid] == nums[mid+1]) {
                            mid++;
                        } else {
                            break;
                        }
                    }
                    return mid + 1;
                } else {
                    while (mid > 0) {
                        if (nums[mid] == nums[mid-1]) {
                            mid--;
                        } else {
                            break;
                        }
                    }
                    return mid -1;
                }
            }
            if (target > nums[mid]) start = mid +1;
            else end = mid -1;
        }
        return isMax ? start : start-1;
    }

    /**
     * my first solution of this problem
     * @param nums
     * @return
     */
    static int findUnsortedSubarray(int[] nums) {
        int i=0;
        int j=1;
        int start = -1;
        int end = nums.length;
        while (i<nums.length-1) {
            j = i+1;
            while (j<nums.length) {
                if (nums[i] > nums[j]) {
                    start = i;
                    break;
                }
                j++;
            }
            if (start != -1) break;
            i++;
        }
        if (start == -1) return 0;
        i = nums.length-1;
        j = nums.length-1;
        while (i>0) {
            j = i-1;
            while (j>=0) {
                if (nums[i] < nums[j]) {
                    end = i;
                    break;
                }
                j--;
            }
            if (end != nums.length) break;
            i--;
        }
        return end - start + 1;
    }
}
