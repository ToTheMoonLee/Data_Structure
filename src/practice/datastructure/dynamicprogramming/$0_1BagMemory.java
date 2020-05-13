package practice.datastructure.dynamicprogramming;

public class $0_1BagMemory {

    public static void main(String[] args) {
        put(0, 0);
        System.out.println("ans is " + ans);
    }

    static int ans = Integer.MIN_VALUE;
    static int[] values = new int[]{2, 2, 4, 6, 3};
    static int n = 5; // the number of values
    static int max = 9; // the bag's max value;
    static boolean[][] memo = new boolean[n][max+1];


    /**
     * using the memo to record positions which were accessed.
     * the time compelexity of this methed is n*max
     * @param position current position of 'values'
     * @param curValue current value the bag has
     */
    static void put(int position, int curValue) {
        // if we reach the end of values's position or our bag's value equals the max value,the return the function
        if (position == n || curValue == max) {
            if (curValue > ans) {
                ans = curValue;
            }
            return;
        }
        if (memo[position][curValue]) return;
        else memo[position][curValue] = true;
        put(position + 1, curValue);
        if (curValue+values[position] <= max) {
            put(position + 1, curValue+values[position]);
        }
    }
}
