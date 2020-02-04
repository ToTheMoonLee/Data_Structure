package practice.hanoi;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(8, "X", "Y", "Z");
        System.out.println(" count ==== " + count);
    }

    private static int count = 0;

    private static void hanoi(int n, String from, String buffer, String to) {
        if (n == 0) {
            return;
        }
        count++;
        hanoi(n - 1, from, to, buffer);
        System.out.println(" move n: " + n + " form: " + from + " to: " + to);
        hanoi(n - 1, buffer, from, to);
    }
}
