package practice.leetcode.easy;

public class $278FirstBadVersion {

    static int target = 3;
    public static void main(String[] args) {

    }

    /**
     * their solution of this problem
     * @param n
     * @return
     */
    static int firstBadVersion2(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    /**
     * my solution of this problem
     * @param n
     * @return
     */
    static int firstBadVersion(int n) {
        int s = 1;
        int e = n;
        int m = 0;
        if (n == 2) {
            return isBadVersion(2) && isBadVersion(1) ? 1 : 2;
        }
        while (s<=e) {
            m = s+(e-s)/2;
            boolean b1 = isBadVersion(m);
            if (b1 && !isBadVersion(m-1) || m==1) return m;
            if (b1) e = m-1;
            else s =m+1;
        }
        return 0;
    }

    static boolean isBadVersion(int version){
       return version>=target;
    }
}
