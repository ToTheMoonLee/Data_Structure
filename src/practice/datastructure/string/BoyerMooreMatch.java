package practice.datastructure.string;

/**
 * 算法思路：使用坏字符和好后缀原则，假主串长度为n，模式串为m，
 * 匹配主串中的n-m+1个字串是否和模式串相同，匹配方式为从后往前匹配
 *
 * 1. 坏字符原则，若出现不匹配时，记录该字符在模式串中的位置为si，然后查找该字符
 * 在模式串中最后出现的位置记为xi，没有在模式串中，则记为-1，直接将模式串向后滑动
 * si-xi继续比较，如下：
 *
 * case1:
 *         不匹配
 *           ↓
 *     A B C D E F G
 *     A B C H
 *   ↑       ↑
 *   xi      si=3 xi=-1 移动si-xi
 *             A B C H
 *
 * case2:
 *         不匹配
 *           ↓
 *     A B C B E F G
 *     A B C H
 *      ↑    ↑
 *      xi   si=3  xi=1 移动si-xi
 *         A B C H
 * 2. 好后缀原则：
 *    在主串中出现与模式串匹配的后缀{u}，则查看在模式串中是否也有匹配的后缀串{u*}，
 *    如果有，则滑动到{u*}的位置；如果没有，则找到是否有与模式串的前缀串匹配的{u}的最大后缀串
 *    如果有，则滑动到{u}的最大后缀串与模式串重合的位置；
 *    如果都没有，则直接滑动到最后。
 *
 * case1:
 *     A B C A E F C E F
 *     A E F C E F
 *           A E F C E F
 *
 * case2:
 *    A B C D E F A D E F
 *    E F A D E F
 *            E F A D E F
 *
 * case2:
 *    A B C D A E C D
 *    A E C D
 *            A E C D
 *
 * 3. 上述两种原则可以对模式串进行预处理，使用数组存储需要滑动的距离，可以使用哈希表进行
 * 优化，减少滑动时间
 * 4. 在循环匹配的过程中，在上述两种规则中选择滑动最长值进行滑动
 */
public class BoyerMooreMatch extends BaseString{

    private static int MAX_SIZE = 256;

    public static void main(String[] args) {
        initData();
        int match = match(T, P);
        System.out.println("match is " + match);
        int match2 = match(T, P2);
        System.out.println("match2 is " + match2);
    }

    /**
     * BM算法，从主串t中匹配模式串p
     * @param t 主串
     * @param p 模式串
     * @return 模式串p在主串t中第一次出现的位置
     */
    private static int match(char[] t,char[] p) {
        int[] bc = new int[MAX_SIZE];
        int[] suffix = new int[p.length];
        boolean[] prefix = new boolean[p.length];
        generateBC(p, bc);
        generateGS(p, suffix, prefix);
        int i = 0;
        int n = t.length;
        int m = p.length;
        while (i < n - m + 1) {
            int j = m - 1; // j为不匹配对位置
            for (; j >= 0; j--) {
                if (p[j] != t[i + j]) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }

            int x = j - bc[(int) t[i + j]];
            int y = 0;
            if (j < m - 1) {
                y = moveIndex(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    private static int moveIndex(int j, int m,int[] suffix, boolean[] prefix) {
        int k = m - j - 1;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        int r = j + 2;
        while (r < m) {
            if (prefix[m - r]) {
                return r;
            }
            r++;
        }
        return m;
    }

    /**
     * 从模式串中，找模式串的后缀（后缀串长度从0到m-1）在模式串中出现的位置
     * 即为从p[0-i],i取0到m-2和p[0-(m-1)]求公共的后缀串
     * @param p 模式串
     * @param suffix 后缀
     * @param prefix 是否是前缀
     */
    private static void generateGS(char[] p, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < p.length; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        int m = p.length;
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && p[j] == p[m - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    /**
     * 构建坏字符数组
     * @param p 模式串
     * @param b 存储坏字符在模式串中的位置的数组
     */
    private static void generateBC( char[] p,int[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i] = -1;
        }
        int i = 0;
        while (i < p.length) {
            b[(int) p[i]] = i;
            i++;
        }
    }

}


























