package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_004 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int a = 999;
        int b = 999;
        int mina = 100;
        int max = 0;
        while (true) {
            if (pal("" + (a*b))) {
                if (a*b > max) {
                    max = a*b;
                    mina = a;
                }
            }
            if (a == mina) {
                a = 999;
                b--;
            } else {
                a--;
            }
            if (a == mina && b == 100) {
                break;
            }
        }
        System.out.println(max);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static boolean pal(String x) {
        for (int i = 0; i < x.length() / 2; i++) {
            if (x.charAt(i) != x.charAt(x.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
