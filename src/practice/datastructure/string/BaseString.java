package practice.datastructure.string;

public class BaseString {

    public static char[] s;
    public static char[] t;
    public static char[] t2;

    public static void initData() {
        s = "abcdabceabcdabcefddd".toCharArray();
        t =         "abcdabcef".toCharArray();  // index 8
        t2 =             "bcef".toCharArray();  // index 8
    }
}
