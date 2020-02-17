package practice.datastructure.string;

public class BaseString {

    public static char[] T;
    public static char[] P;
    public static char[] P2;

    public static void initData() {
        T = "abcdabceabcdabcefddd".toCharArray();
        P =         "abcdabcef".toCharArray();  // index 8
        P2 =             "bcef".toCharArray();  // index 13
    }
}
