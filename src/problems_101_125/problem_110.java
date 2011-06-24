package problems_101_125;

/**
 * @author Jaroslaw Pawlak
 */
public class problem_110 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(n(113));
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static long n(int solutions) {
        int divisors = 2 * solutions - 1;
        int two = 1;
        for (long i = 2; i < divisors; i *=2) {
            two++;
        }
        int three = 0;
        int x = 1;
        while (true) {
            x = 1;
            for (int i = 0; i < two; i++) {
                x *= 2;
            }
            for (int i = 0; i < three; i++) {
                x *= 3;
            }
            if (x > divisors) {
                two--;
                three++;
            } else {
                break;
            }
        }
        System.out.println(x);
        int r = 0;
//        for (int i = 1; i <= n; i++) {
//            if ((n * n) % i == 0) {
//                r++;
//            }
//        }
        return r;
    }
}
