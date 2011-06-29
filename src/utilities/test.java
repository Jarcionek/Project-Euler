package utilities;


/**
 * @author Jaroslaw Pawlak
 */
public class test {
    public static void main(String[] args) {
        for (int i = 10; i <= 100000000; i *= 10) {
            Prime.sieve(i);
            System.out.println(i + ": " + (1d * Prime.getNumberOfPrimes() / i));
        }
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
