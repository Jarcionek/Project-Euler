package problems_001_025;

import java.math.BigInteger;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_020 {
    public static void main(String[] args) {
        BigInteger x = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            x = x.multiply(new BigInteger("" + i));
        }
        System.out.println(x);
        System.out.println(x.toString().toCharArray().length + " digits");


        System.out.println(sumDigits(x));
    }
    private static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be not negative, given: " + n);
        }
        BigInteger x = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            x = x.multiply(new BigInteger("" + i));
        }
        return x;
    }
    private static long sumDigits(BigInteger x) {
        char[] temp = x.toString().toCharArray();
        long sum = 0;
        for (char e : temp) {
            sum += (int) e;
        }
        return sum - temp.length * 48;
    }
}
