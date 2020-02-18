package practice.index;

public class KMPIndex {

    private static int count = 0;

    public static void main(String[] args) {
        char[] S = "abcabcdabcabceff".toCharArray();
        char[] T =        "abcabcef".toCharArray();

        System.out.println(" index is " + index(S, T) + " , count is " + count);
    }

    private static int index(char[] S, char[] T) {
        // 指向S主串
        int i = 0;
        // 指向T模式串
        int j = 0;
        int[] nextArray = getNextArray(T);
        while (i <= S.length) {
            count++;
            while (j == -1 || j < T.length && S[i] == T[j]) {
                count++;
                i++;
                j++;
            }
            if (j == T.length) {
                return i - T.length;
            }
            j = nextArray[j];
        }
        return -1;
    }

    private static int index2(char[] S, char[] T) {
        int i = 0;
        int j = 0;
        int[] nextArray = getNextArray(T);
        while (i < S.length && j < T.length) {
            count++;
            if (j == -1 || S[i] == T[j]) {
                i++;
                j++;
            } else {
                j = nextArray[j];
            }
        }
        if (j == T.length) {
            return i - T.length;
        }
        return -1;
    }

    private static int[] getNextArray(char[] T) {
        int[] next = new int[T.length];
        next[0] = -1;
        int i = -1;
        int j = 0;
        while (j < T.length-1) {
            if (i == -1 || T[i] == T[j]) {
                i++;
                j++;
                next[j] = i;
            } else {
                i = next[i];
            }
        }
        return next;
    }
}
