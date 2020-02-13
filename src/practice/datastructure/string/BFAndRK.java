package practice.datastructure.string;

/**
 * BF和RK算法，将模式串（长度m）与主串（长度n）的
 */
public class BFAndRK extends BaseString {

    public static void main(String[] args) {
        initData();
//        System.out.println(" index is ---> " + bfSearch(s, t));
        System.out.println(" index is ---> " + rkSearch(s, t2));
    }

    private static int rkSearch(char[] s, char[] t) {
        long[] powArr = new long[t.length];
        for (int i = 0; i < powArr.length; i++) {
            powArr[i] = (int) Math.pow(26, powArr.length - 1 - i);
        }
        long tHash = 0;
        for (int i = 0; i < t.length; i++) {
            tHash = tHash + powArr[i] * (t[i] - 'a');
        }
        long[] sHash = new long[s.length - t.length + 1];


        int k = 0;
        for (int i = 0; i < s.length; i++) {
            if (i < t.length) {
                sHash[k] = sHash[k] + powArr[i] * (s[i] - 'a');
            } else {
                k++;
                sHash[k] = (sHash[k - 1] - powArr[0] * (s[i - t.length] - 'a')) * 26 + powArr[t.length - 1] * (s[i] - 'a');
            }
        }
        for (int i = 0; i < k; i++) {
            if (sHash[i] == tHash) {
                return i;
            }
        }

        return -1;
    }

    private static int bfSearch(char[] s, char[] t) {
        int j = 0;
        int i = 0;
        for (; i < s.length - t.length + 1; i++) {
            while (j < t.length && s[i + j] == t[j]) {
                j++;
            }
            if (j >= t.length) {
                break;
            }
            j = 0;
        }
        if (j >= t.length) {
            return i;
        }
        return -1;
    }
}
