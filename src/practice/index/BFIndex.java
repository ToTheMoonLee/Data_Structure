package practice.index;

public class BFIndex {

    private static int count = 0;
    public static void main(String[] args) {
        char[] S = "abcabcdabcabceff".toCharArray();
        char[] T =        "abcabce".toCharArray();

        System.out.println(" index is " + index(S, T) + " , count is " + count);

    }


    private static int index(char[] S, char[] T) {
        // 指向S主串
        int i = 0;
        // 指向T模式串
        int j = 0;
        while (i <= (S.length - T.length)) {
            int k = i;
            count++;
            while (j < T.length && S[i] == T[j]) {
                i++;
                j++;
                count++;
            }
            if (j == T.length) {
                return i - T.length;
            }
            i = k + 1;
            j = 0;
        }
        return -1;
    }
}
