package problems_026_050;

import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_047 {
    private static final int L = 4;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        Prime.sieve(1000000);
        String pattern = "[0-9^\\s]+";
        for (int i = 1; i < L; i++) {
            pattern += "\\*[0-9^\\s]+";
        }
        for (int i = 1; i > 0; i++) {
            boolean ok = true;
            for (int j = 0; j < L; j++) {
                if (!Prime.getPrimeFactorization(i + j).matches(pattern)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                result = i;
                break;
            }
        }

        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
