package problems_001_025;

import java.math.BigInteger;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_025 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int i = 1;
        while (f(i).toString().length() < 1000) {
            i++;
        }
        System.out.println(i);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static BigInteger f(int i) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;
        for (; i > 2; i--) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }
}
