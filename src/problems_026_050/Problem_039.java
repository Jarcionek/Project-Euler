package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_039 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        int max = 0;
        for (int p = 3; p <= 1000; p++) {
            int t = count(p);
            if (t > max) {
                max = t;
                result = p;
            }
        }

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static int count(int p) {
        int r = 0;

        for (int a = 1; a < p; a++) {
            int x = p * (2 * a - p);
            int y = 2 * (a - p);
            if (x % y == 0 && a < x / y) {
                r++;
//                System.out.println(a + " " + (x/y));
            }

        }

        return r;
    }
}
