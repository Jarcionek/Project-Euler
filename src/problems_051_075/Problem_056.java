package problems_051_075;

import java.math.BigInteger;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_056 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                BigInteger x = new BigInteger("" + a).pow(b);
                int t = 0;
                for (char e : x.toString().toCharArray()) {
                    t += e - '0';
                }
                if (t > result) {
                    result = t;
                }
            }
        }

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
