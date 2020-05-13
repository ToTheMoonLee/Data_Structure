package practice.datastructure.backtracking;

/**
 * solving the 8 queens problem with the backtracking algorithm. 使用回溯思想，解决8皇后问题
 */
public class EightQueens {

    private static int[] result = new int[8];

    public static void main(String[] args) {
        call8queens(0);
    }


    private static void call8queens(int row) {
        if (row == 8) {
            print8queens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                call8queens(row + 1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int left = column - 1;
        int right = column + 1;
        for (int j = row - 1; j >= 0; j--) {
            if (left >= 0 && result[j] == left) {
                return false;
            }
            if (right < 8 && result[j] == right) {
                return false;
            }
            if (result[j] == column) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    private static void print8queens(int[] arr) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (arr[row] == column) {
                    System.out.print("x ");
                } else {
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
