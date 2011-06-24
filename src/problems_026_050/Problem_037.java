package problems_026_050;

import utilities.Utilities;
import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_037 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 23;

        Prime.sieve(1000000);
        int n = 0;

        for (int i = 11; i > 0; i += 2) {
            String t = "" + i;
            if (t.contains("0")
                    || t.contains("2")
                    || t.contains("4")
                    || t.contains("6")
                    || t.contains("8")) {
                continue;
            }
            boolean ok = Prime.isPrime(i);
            if (!ok) {
                continue;
            }
            for (int j = 1; j < t.length(); j++) {
                if (!Prime.isPrime(i / Utilities.pow(10, j))
                        || !Prime.isPrime(i % Utilities.pow(10, j))) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                result += i;
                System.out.println(i);
                n++;
                if (n == 10) {
                    break;
                }
            }
        }

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
