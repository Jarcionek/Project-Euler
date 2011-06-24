package problems_076_100;

import utilities.Utilities;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_097 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = Utilities.pow(2, 7830457, 10000000000L);

        result *= 28433;
        result += 1;
        result %= 10000000000L;

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
