package problems_051_075;

import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_058 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 3;

        Prime.sieve(100000000);

        int n = 9; // current number
        int incrementor = 4;
        int counter = 0;
        int prime = 3;
        int notprime = 5;
        while (10 * prime >= notprime) {
            n += incrementor;
            System.out.print(n + ": ");
            counter++;
            notprime++;
            if (Prime.isPrime(n)) {
                prime++;
            }
            if (counter == 4) {
                counter = 0;
                incrementor += 2;
            } else if (counter == 1) {
                result += 2;
            }
            System.out.print(result + " - ");
            System.out.print(prime + "/" + notprime + " = ");
            System.out.println(1d * prime / notprime);
        }

        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
