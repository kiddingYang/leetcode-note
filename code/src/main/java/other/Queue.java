package other;

public class Queue {


    private static int[][] queue = new int[8][8];

    private static int total = 1;

    public static void main(String[] args) {
        findQueue(0);
    }


    /**
     * 当棋子摆放在第{row}行时
     */
    public static void findQueue(int row) {
        if (row > 7) {
            System.out.println("print : " + total++);
            print(queue);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (ok(row, column)) {
                queue[row][column] = 1;
                findQueue(row + 1);
                queue[row][column] = 0;
            }
        }
    }

    private static void print(int[][] queue) {
        for (int[] row : queue) {
            for (int c : row) {
                System.out.print(c + " ");
            }
            System.out.println("");
        }
        System.out.println("-----------------------------------");
    }


    /**
     * 判断第{row}行,第{column}的棋子是否可以摆放
     */
    public static boolean ok(int k, int j) {
//        for (int i = 0; i < 8; i++) {//检查行列冲突
//            if (queue[i][column] == 1) {
//                return false;
//            }
//
//            for (int j = 0; j < 8; j++) {
//                if (queue[i][j] == 1 && (row + j == i + column)) {
//                    return false;
//                }
//            }
//        }
//        return true;
        for (int i = 0; i < 8; i++) {//检查行列冲突
            if (queue[i][j] == 1) {
                return false;
            }
        }
        for (int i = k - 1, m = j - 1; i >= 0 && m >= 0; i--, m--) {//检查左对角线
            if (queue[i][m] == 1) {
                return false;
            }
        }
        for (int i = k - 1, m = j + 1; i >= 0 && m <= 7; i--, m++) {//检查右对角线
            if (queue[i][m] == 1) {
                return false;
            }
        }
        return true;
    }
}
