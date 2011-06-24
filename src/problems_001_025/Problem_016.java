package problems_001_025;

import java.math.BigInteger;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_016 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BigInteger x = new BigInteger("2");
        x = x.pow(1000);
        int result = 0;
        for (char e : x.toString().toCharArray()) {
            result += (int) e - 48;
        }
        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
