package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_028 {
    private static final int SIZE = 1001;
    private static int[][] x = new int[SIZE][SIZE];

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int i = SIZE / 2; // 0 for left, SIZE for right
        int j = SIZE / 2; // 0 for top, SIZE for bottom
        int dir = 1; // 1 - right, 2 - down, 3 left, 4 up
        x[i][j] = 1;
        int number = 1;
        try {
            while (true) {
                number++;
                switch (dir) {
                    case 1: // goind right
                        if (x[i][j+1] == 0) {
                            x[i][j+1] = number;
                            dir = 2;
                            j++;
                        } else {
                            x[i+1][j] = number;
                            i++;
                        }
                        break;
                    case 2: // going down
                        if (x[i-1][j] == 0) {
                            x[i-1][j] = number;
                            dir = 3;
                            i--;
                        } else {
                            x[i][j+1] = number;
                            j++;
                        }
                        break;
                    case 3: // going left
                        if (x[i][j-1] == 0) {
                            x[i][j-1] = number;
                            dir = 4;
                            j--;
                        } else {
                            x[i-1][j] = number;
                            i--;
                        }
                        break;
                    case 4: // going up
                        if (x[i+1][j] == 0) {
                            x[i+1][j] = number;
                            dir = 1;
                            i++;
                        } else {
                            x[i][j-1] = number;
                            j--;
                        }
                        break;
                }
            }
        } catch (IndexOutOfBoundsException ex) {}

        int result = -1;
        for (int a = 0; a < SIZE; a++) {
            result += x[a][a];
            result += x[SIZE - 1 - a][a];
        }
        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
