package problems_026_050;

import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_050 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Prime.isPrime(1000000);
        long best = -1;
        int max = 0;
        int current = 0;
        for (int i = Prime.getNumberOfPrimes() - 1; i > Prime.getNumberOfPrimes() - 1000; i--) {
            System.out.println(i);
            long prime = Prime.get(i);
            for (int first = 0; first < Prime.getNumberOfPrimes(); first++) {
                int result = 0;
                current = 0;
                for (int j = first; Prime.get(j) < prime; j++) {
                    result += Prime.get(j);
                    current++;
                    if (result == prime) {
                        if (current > max) {
                            max = current;
                            best = prime;
                        }
                    } else if (result > prime) {
                        break;
                    }
                }
            }
        }
        System.out.println(best);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
