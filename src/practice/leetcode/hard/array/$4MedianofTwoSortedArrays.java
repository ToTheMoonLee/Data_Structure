package practice.leetcode.hard.array;

public class $4MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    /**
     * my first solution of this problem, O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] < nums2[k]) {
                merge[i] = nums1[j];
                i++;
                j++;
            } else {
                merge[i] = nums2[k];
                i++;
                k++;
            }
        }
        while (j < nums1.length) {
            merge[i] = nums1[j];
            i++;
            j++;
        }
        while (k < nums2.length) {
            merge[i] = nums2[k];
            i++;
            k++;
        }

        return merge.length % 2 == 0 ? (merge[merge.length/2] + merge[merge.length/2-1])/2d : merge[merge.length/2];
    }


}
