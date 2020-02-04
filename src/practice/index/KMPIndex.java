package practice.index;

public class KMPIndex {

    private static int count = 0;

    public static void main(String[] args) {
        char[] S = "abcabcdabcabceff".toCharArray();
        char[] T =        "abcabcee".toCharArray();

        System.out.println(" index is " + index(S, T) + " , count is " + count);
    }

    private static int index(char[] S, char[] T) {
        // 指向S主串
        int i = 0;
        // 指向T模式串
        int j = 0;
        int[] nextArray = getNextArray(T);
        while (i <= (S.length - T.length)) {
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
        int[] arr = new int[T.length];
        arr[0] = -1;
        if (T.length <= 1) {
            return arr;
        }
        int i = 0;
        int j = 1;

        while (j < T.length) {
            if (i == 0 || T[i] == T[j]) {
                arr[j] = i;
                j++;
                i++;
            } else {
                i = arr[i];
            }
        }

        return arr;
    }
}
