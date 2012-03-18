package problems_026_050;

import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_046 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("-> " + calculate());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static long calculate() {
        long result = 0;
        
        Prime.sieve(Integer.MAX_VALUE);
        number:
        for (int number = 9; number < Integer.MAX_VALUE; number += 2) {
            if (Prime.isPrime(number)) {
                continue;
            }
            for (int primeIndex = Prime.getNumberOfPrimes() - 1;
                    primeIndex >= 0; primeIndex--) {
                int prime = (int) Prime.get(primeIndex);
                if (prime <= number) {
                    for (int square = 1; true; square++) {
                        if (prime + 2 * square * square == number) {
                            continue number;
                        } else if (prime + 2 * square * square > number) {
                            break;
                        }
                    }
                }
            }
            result = number;
            break;
        }
        
        return result;
    }
}
