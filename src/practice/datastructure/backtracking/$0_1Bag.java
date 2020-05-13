package practice.datastructure.backtracking;

/**
 * 我们有一个背包，背包总的承载重量是 Wkg。
 * 现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。
 * 在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 */
public class $0_1Bag {

    public static void main(String[] args) {
        put(0, 0);
        System.out.println("the answer is " + ans);
    }

    static int ans = Integer.MIN_VALUE;
    static int[] values = new int[]{2, 2, 4, 6, 3};
    static int n = 5; // the number of values
    static int max = 9; // the bag's max value;

    /**
     * the time compelexity of this methed is 2^n
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
        put(position + 1, curValue);
        if (curValue+values[position] <= max) {
            put(position + 1, curValue+values[position]);
        }
    }
}
