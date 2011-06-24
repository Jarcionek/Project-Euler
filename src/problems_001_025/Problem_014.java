package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_014 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int max = 0;
        int ibest = 0;
        for (int i = 1; i < 1000000; i++) {
            int t = x(i);
            if (t > max) {
                max = t;
                ibest = i;
            }
        }
        System.out.println(ibest);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static int x(int n) {
        int result = 1;
        long last = n;
        while (last != 1) {
            if (last % 2 == 0) {
                last /= 2;
            } else {
                last = 3 * last + 1;
            }
            result++;
        }
        return result;
    }
}
