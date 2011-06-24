package problems_026_050;

import utilities.*;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_035 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Prime.sieve(1000000);
        int result = 1; //i = 2

        for (int i = 1; i < 1000000; i += 2) { //cannot contain even digits
//            if ((i - 1) % 1000 == 0) {
//                System.out.println("i = " + (i-1));
//            }

            int[] digits = Utilities.getDigits(i);
            boolean prime = true;
            for (int j = 0; j < digits.length; j++) {
                int number = 0;
                int mult = 1;
                for (int k = digits.length - 1; k >= 0; k--) {
                    int[] temp = Utilities.getRotation(digits.length, j);
                    number += digits[temp[k]] * mult;
                    mult *= 10;
                }
                if (!Prime.isPrime(number)) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.println(i);
                result++;
            }
        }

        System.out.println("-> " + result);

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}