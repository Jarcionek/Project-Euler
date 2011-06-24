package problems_026_050;

import java.awt.Toolkit;
import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_027 {
    private static final int N = 1000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        Prime.sieve(1000000);

        int max = 0;
        int maxA = 1, maxB = 1;

        for (int a = -N + 1; a < N; a++) {
            System.out.println(a);
            for (int b = -N + 1; b < N; b++) {
                int current = 0;
                int i = 0;
                int temp;
                while ((temp = i * i + a * i + b) > 0 && Prime.isPrime(temp)) {
                    current++;
                    i++;
                }
                if (current > max) {
                    max = current;
                    maxA = a;
                    maxB = b;
                    System.out.println(max + " " + maxA + " " + maxB);
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        result = maxA * maxB;

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
