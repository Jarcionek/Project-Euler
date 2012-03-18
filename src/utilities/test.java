package utilities;

/**
 * @author Jaroslaw Pawlak
 */
public class test {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Prime.sieve(500000000);
        while (Prime.getBiggest() < Integer.MAX_VALUE) {
            Prime.get(Prime.getNumberOfPrimes());
        }
        System.out.println("biggest: " + Prime.getBiggest());
        System.out.println("size: " + Prime.getNumberOfPrimes());
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
    private static int f(int n) {
        return n == 0? 1 : n * f(n-1);
    }
    /**
     * (a ^ b) % l
     */
    private static int p(int a, int b, int l) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
            result %= l;
        }
        return result;
    }
}
