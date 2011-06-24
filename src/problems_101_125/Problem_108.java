package problems_101_125;

import java.math.BigInteger;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_108 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 4;
        int solutions = 0;
        while (solutions <= 1000) {
            n += 2;
            solutions = solutions4(n);
        }
        System.out.println("solutions = " + solutions);
        System.out.println("n = " + n);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int solutions(int n) {
        int result = 0;
        int x = n * 2;
        int y = n * 2;
        while (x > n) {
            if (n * (x+y) == x * y) {
                result++;
                x--;
                y++;
            } else if (n * (x+y) > x * y) {
                y++;
            } else {
                x--;
            }
        }
        return result;
    }

    private static int solutions2(int n) {
        int result = 0;
        long x = n * 2;
        while (x > n) {
            if ((n * x) % (n - x) == 0 ) {
                result++;
            }
            x--;
        }
        return result;
    }

    private static int solutions3(int n) {
        int result = 0;
        int x = n * 2;
        while (x > n) {
            BigInteger one = new BigInteger("" + n);
            one = one.multiply(new BigInteger("" + x));
            BigInteger two = new BigInteger("" + x);
            two = two.subtract(new BigInteger("" + n));
            if (one.divideAndRemainder(two)[1].equals(BigInteger.ZERO)) {
                result++;
                System.out.println(x + " " + one.divide(two));
            }
            x--;
        }
        return result;
    }

    private static int solutions4(long n) {
        int r = 0;
        for (int i = 1; i <= n; i++) {
            if ((n * n) % i == 0) {
                r++;
            }
        }
        return r;
    }
}
