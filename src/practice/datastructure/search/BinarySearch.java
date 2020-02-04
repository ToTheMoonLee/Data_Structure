package practice.datastructure.search;

public class BinarySearch extends BaseSearch {

    public static void main(String[] args) {
        // arr ---> 1, 4, 5, 7, 8, 9, 11, 14, 17, 18, 21, 22, 29, 31, 32, 34, 36, 37, 40
        // arr1 ---> 1, 4, 5, 7, 8, 9, 11, 11,11,11,11,11,11,11, 14, 17, 18, 21, 22, 29, 31, 32, 34, 36, 37, 40
//        int result = binarySearch(arr, 11);
//        System.out.println(" arr[" + result + "] is ---> " + arr[result]);
//        int result2 = binarySearch(arr, 12);
//        System.out.println(" arr[" + result2 + "] is ---> ");

//        int result = RecursionBinary(arr, 11);
//        System.out.println(" arr[" + result + "] is ---> " + arr[result]);
//        int result2 = RecursionBinary(arr, 12);
//        System.out.println(" arr[" + result2 + "] is ---> " );

//        int result = findTheFirstTarget(arr1, 11);
//        System.out.println(" arr[" + result + "] is ---> " + arr1[result]);
//        int result2 = RecursionBinary(arr1, 11);
//        System.out.println(" arr[" + result2 + "] is ---> " + arr1[result2]);

        int result = findTheFirstBiggerTarget(arr1, 11);
        System.out.println(" arr[" + result + "] is ---> " + arr1[result]);
        int result2 = RecursionBinary(arr1, 11);
        System.out.println(" arr[" + result2 + "] is ---> " + arr1[result2]);
    }

    /**
     * find the first index that bigger than target
     * @param arr
     * @param target
     * @return
     */
    private static int findTheFirstBiggerTarget(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (target == arr[middle]) {
                if (middle == arr.length - 1) {
                    return -1;
                } else if (target != arr[middle + 1]) {
                    return middle + 1;
                } else {
                    low = middle + 1;
                }

            } else if (target < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    private static int findTheFirstTarget(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (target == arr[middle]) {
                if (middle == 0 || target != arr[middle - 1]) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else if (target < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * recursion version
     *
     * @param arr
     * @param target
     * @return
     */
    private static int RecursionBinary(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    private static int search(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int middle = low + ((high - low) >> 1);
        if (arr[middle] == target) {
            return middle;
        }
        if (target < arr[middle]) {
            return search(arr, low, middle - 1, target);
        } else {
            return search(arr, middle + 1, high, target);
        }
    }

    /**
     * loop version
     *
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (arr[middle] == target) {
                return middle;
            }
            if (target < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
