package problems_026_050;

import java.math.BigInteger;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_048 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            result = result.add((new BigInteger("" + i)).pow(i));
        }
        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
