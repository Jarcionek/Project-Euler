package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_015 {
    private static final int SIZE = 21;

    private static long[][] x = new long[SIZE][SIZE];
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            x[0][i] = 1;
            x[i][0] = 1;
        }
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                x[i][j] = x[i-1][j] + x[i][j-1];
            }
        }
        System.out.println(x[SIZE-1][SIZE-1]);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
