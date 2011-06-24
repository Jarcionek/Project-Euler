package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_002 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = 0;
        int i = 1;
        while (true) {
            if (f(i) > 4000000) {
                break;
            }
            if (f(i) % 2 == 0) {
                result += f(i);
            }
            i++;
        }
        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    /**
     * f(1) = 1, f(2) = 2, f(3) = 3
     */
    private static int f(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
