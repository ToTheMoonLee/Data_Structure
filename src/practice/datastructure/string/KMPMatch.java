package practice.datastructure.string;

public class KMPMatch extends BaseString {

    public static void main(String[] args) {
        initData();
        int result = kmp1(T, P);
        System.out.println("result is " + result);
        int result2 = kmp2(T, P);
        System.out.println("result is " + result2);
    }

    private static int kmp2(char[] t, char[] p) {
        int i = 0;
        int j = 0;
        int[] next2 = getNext2(p);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next2[j];
            }
        }
        if (j == p.length) {
            return i - p.length;
        }
        return -1;
    }

    /**
     * 获取到next数组，该数组中下标的值，表示在当前下标出现失配时，应该跳转从哪个下标开始比对，-1为第0个位置时的特殊值，
     * 也可以表示为当前元素之前的所有元素的，可匹配最长前缀，如下：
     *  ababcababa 这个数组的字串为,分别对应的
     *  a                               -1
     *  ab                               0
     *  aba                              0
     *  abab                             1
     *  ababc                            2
     *  ababca                           0
     *  ababcab                          1
     *  ababcaba                         2
     *  ababcabab                        3
     *  ababcababa                       4
     *
     *  所以next数组为 -1 0 0 1 2 0 1 2 3 4
     *
     * @param p 模式串
     * @return 返回对应的next数组，如上所示
     */
    private static int[] getNext2(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int j = -1;
        int i = 0;
        while (i < p.length) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                if (i < p.length) {
                    next[i] = j;
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 使用的next数组如{@link #getNext1(char[])}所描述，所以在取j时，需要取前一个的值
     * @param t 主串
     * @param p 模式串
     * @return 匹配的位置
     */
    private static int kmp1(char[] t, char[] p) {
        int[] next = getNext1(p);
        int m = p.length;
        int j = 0;
        for (int i = 0; i < t.length; i++) {
            while (j > 0 && t[i] != p[j]) {
                j = next[j - 1] + 1;
            }
            if (t[i] == p[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 获取到next数组，该数组中下标的值，表示当前下标下，后缀能与前缀匹配的，最长可匹配前缀最后一位的下标，-1为不存在，如下：
     *  ababcababa 这个数组的字串为,分别对应的
     *  a                               -1
     *  ab                              -1
     *  aba                              0
     *  abab                             1
     *  ababc                            0
     *  ababca                           0
     *  ababcab                          1
     *  ababcaba                         2
     *  ababcabab                        3
     *  ababcababa                       2
     *
     *  所以next数组为 -1 -1 0 1 0 0 1 2 3 2
     *
     * @param p 模式串
     * @return 返回对应的next数组，如上所示
     */
    private static int[] getNext1(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < p.length; i++) {
            while (k != -1 && p[k + 1] != p[i]) {
                k = next[k];
            }
            if (p[k + 1] == p[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
















