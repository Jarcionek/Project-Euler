package problems_051_075;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_052 {
    private static final int N = 6;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        for (int x = 1; x > 0; x++) {
            boolean ok = true;

            //digits of x in 2x, 3x, ... Nx
            for (char e : ("" + x).toCharArray()) {
                for (int i = 2; i <= N; i++) {
                    if (!("" + i*x).contains("" + e)) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    break;
                }
            }
            if (!ok) {
                continue;
            }

            //digits of 2x, 3x, ... Nx in x
            for (int i = 2; i <= N; i++) {
                for (char e : ("" + i*x).toCharArray()) {
                    if (!("" + x).contains("" + e)) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    break;
                }
            }

            if (ok) {
                for (int j = 1; j <= N; j++) {
                    System.out.println(j + "x = " + (x*j));
                }
                System.out.println("============");
            }
        }

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
