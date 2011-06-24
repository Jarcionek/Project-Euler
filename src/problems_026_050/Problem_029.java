package problems_026_050;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_029 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set<BigInteger> set = new HashSet<BigInteger>(100*100);
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                set.add(pow(new BigInteger("" + a), new BigInteger("" + b)));
            }
        }

        System.out.println(set.size());

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        } else if ( b == 1) {
            return a;
        } else if ( b == 2) {
            return a * a;
        } else {
            return ((b & 1) == 1 ? a : 1) * pow(pow(a, b/2), 2);
        }
//        if ((b & 1) == 1) {
//            return a * pow(pow(a, b/2), 2);
//        } else {
//            return pow(pow(a, b/2), 2);
//        }

//        return b == 0? 1 : a * pow(a, b - 1);
    }
    private static BigInteger pow(BigInteger a, BigInteger b) {
        BigInteger two = new BigInteger("2");
        if (b.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else if (b.equals(BigInteger.ONE)) {
            return a;
        } else if (b.equals(two)) {
            return a.multiply(a);
        } else if (b.remainder(two).equals(BigInteger.ONE)) {
            return a.multiply(pow(pow(a, b.divide(two)), two));
        } else {
            return pow(pow(a, b.divide(two)), two);
        }
    }
}