package utilities;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * The class <code>Prime</code> contains basic operations with prime numbers
 * such as primality testing, finding the number of divisors of a number,
 * finding all divisors of a number or representing a number in prime
 * factorization.
 * 
 * <p>
 * 
 * The class finds prime numbers dynamically when necessary or they can be
 * found in advance using sieve of Eratosthenes (see <code>{@link #sieve}</code>).
 *
 * <p>
 *
 * All found prime numbers are stored as a static array list.
 *
 * @version 1.01 29/06/2011
 * @author Jaroslaw Pawlak
 */
public class Prime {
    private static final List<Long> PRIME = init();

    private Prime() {};

    private static List<Long> init() {
        ArrayList<Long> x = new ArrayList<Long>();
        x.add(2L);
        return x;
    }


    //PUBLIC


    /**
     * Returns a total number of positive divisors including 1 and the number
     * itself. For negative values returns a number of all positive divisors.
     * @param number a number which divisors are to be found
     * @return a total number of divisors including 1 and a number itself
     * @throws IllegalArgumentException
     *         If <code>number == 0</code>
     */
    public static int getNumberOfDivisors(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("0 has an infite number of divisors");
        } else if (number < 0) {
            number = -number;
        }

        int exponent;
        int result = 1;
        int i = 0;
        while (number != 1) {
            if (i >= PRIME.size()) {
                addNew();
            }
            exponent = 0;
            while (number % PRIME.get(i) == 0) {
                exponent++;
                number /= PRIME.get(i);
            }
            result *= exponent + 1;
            i++;
        }
        return result;
    }
    
     //FIXME returns the sum of prime divisors, not all divisors
//    public static int getSumOfDivisors(long number) {
//        while (getBiggest() <= number) {
//            addNew();
//        }
//        
//        int result = 0;
//        for (int i = 0; Prime.get(i) <= number; i++) {
//            if (number % PRIME.get(i) == 0) {
//                result += PRIME.get(i);
//            }
//        }
//        System.out.println("n: " + number);
//        System.out.println("r: " + result);
//        return result;
//    }

    /**
     * Returns i'th prime number, where 0'th is 2. If <code>i</code> is greater
     * than the number of prime numbers found so far, it finds new prime numbers
     * until i'th prime number is found.
     * @param i index of the prime number which should be returned
     * @return i'th prime number
     * @throws IllegalArgumentException
     *         If <code>i < 0</code>
     */
    public static long get(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("i must not be negative: " + i);
        }
        while (i >= PRIME.size()) {
            addNew();
        }
        return PRIME.get(i);
    }

    /**
     * Returns prime factorization of a given <code>number</code>. E.g. for 360
     * it returns "2^3 * 3^2 * 5".
     * @param number a number to be printed as prime factorization
     * @return a string representing prime factorization of a <code>number</code>
     */
    public static String getPrimeFactorization(long number) {
        if (number == 0) {
            return "0";
        } else if (number == 1) {
            return "1";
        } else if (number == -1) {
            return "-1";
        }
        String result = "";
        if (number < 0) {
            number = -number;
            result += "-1*";
        }

        int exponent;
        int i = 0;
        while (true) {
            while (i >= PRIME.size()) {
                addNew();
            }
            exponent = 0;
            while (number % PRIME.get(i) == 0) {
                exponent++;
                number /= PRIME.get(i);
            }
            if (exponent != 0) {
                result += PRIME.get(i);
                if (exponent > 1) {
                    result += "^" + exponent;
                }
                if (number != 1) {
                    result += " * ";
                }
            }
            if (number == 1) {
                break;
            }
            i++;
        }
        return result;
    }

    /**
     * This method really does what its name says it does. Negative numbers are
     * considered not prime.
     * @param number a number to be checked
     * @return true if <code>number</code> is prime, false otherwise
     * @throws IllegalArgumentException
     *         If <code>number <= 0</code>
     */
    public static boolean isPrime(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number has to be positive: " + number);
        } else if (number < 2) {
            //it is not necessary but saves an effort of looking through entire list
            return false;
        } else if (number < getBiggest()) {
            return PRIME.contains(number);
        } else {
            while (getBiggest() < number) {
                addNew();
            }
            return number == getBiggest();
        }
    }

    /**
     * Returns an array of all positive divisors of a <code>number</code>,
     * including 1 and a number itself. An array is not sorted.
     * @param number a number which divisors are to be found
     * @return unsorted distinct divisors of <code>number</code>
     * @throws IllegalArgumentException
     *         If <code>number == 0</code>
     */
    public static long[] getAllDivisors(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("0 has an infite number of divisors");
        } else if (number < 0) {
            number = -number;
        }
        if (number == 1) {
            return new long[] {1};
        }
        long[] result = new long[getNumberOfDivisors(number)];

        //find only those prime numbers which a "number" is divisible by
        //and their exponents
        List<Long> prime = new ArrayList<Long>();
        List<Integer> exp = new ArrayList<Integer>();
        int x = -1;
        for (int i = 0; i < PRIME.size(); i++) {
            if (number % PRIME.get(i) == 0) {
                prime.add(PRIME.get(i));
                exp.add(0);
                x++;
            }
            while (number % PRIME.get(i) == 0) {
                number /= PRIME.get(i);
                exp.set(x, exp.get(x) + 1);
            }
        }

        //find all possibile arrangements of exponents
        int[] current = new int[exp.size()];
            /*
             * "current" is considered as a number where cells are its consecutive
             * digits. Every digit is using different radix system depending
             * on "exp". So, for example, if "exp" is [2, 3], then adding one
             * to "current" we obtain: 00, 10, 20, 01, 11, 21, 02, 12, 22, 03, 13,
             * 23. As you can see, the order of digits is swapped - it does not
             * affect a result (all possibilities has to be generated), but makes
             * algorithm below a bit easier.
             */
        for (int i = 0; i < result.length; i++) {
            //multiply
            long r = 1;
            for (int j = 0; j < current.length; j++) {
                r *= pow(prime.get(j), current[j]);
            }

            //set as i'th element
            result[i] = r;

            //move to next column
            current[0]++;
            for (int j = 0; j < current.length - 1; j++) {
                if (current[j] > exp.get(j)) {
                    current[j] = 0;
                    current[j + 1]++;
                }
            }
        }

        return result;
    }

    /**
     * Returns the number of prime numbers generated so far.
     * @return the number of prime numbers generated so far
     */
    public static int getNumberOfPrimes() {
        return PRIME.size();
    }

    /**
     * Finds all the prime numbers which are smaller than <code>number</code>.
     * This method may generate more prime numbers than is asked for.
     * <p>
     * This method uses sieve of Eratosthenes so it works extremaly fast,
     * but requires a lot of memory (it may require to change memory available
     * for JVM for bigger numbers). E.g. for 2*10^9 it requires 250MB.
     * If you know that you will need large prime numbers, it is recommended
     * to invoke this method first. If <code>number &lt;= 0</code> this method
     * does nothing.
     * @param number the biggest number which should be checked if is prime
     */
    public static void sieve(int number) {
        if (number <= 0) {
            return;
        } else if (number + 1 < 0) { //overflow
            number--;
        }
        BitSet notprime = new BitSet(number + 1);
        for (int i = 2; i < notprime.size(); i++) {
            if (!notprime.get(i)) {
                for (int j = i + i; j < notprime.size(); j += i) {
                    notprime.set(j, true);
                }
            }
        }
        for (int i = (int) getBiggest() + 1; i < notprime.size(); i++) {
            if (!notprime.get(i)) {
                PRIME.add(0L + i);
            }
        }
    }
    
    /**
     * Returns the greatest found prime number.
     * @return the greatest found prime number
     */
    public static long getBiggest() {
        return PRIME.get(PRIME.size() - 1);
    }
    
    public static Iterable<Long> allPrimeNumbers() {
        return PRIME;
    }

    
    //PRIVATE


    private static void addNew() {
        for (long i = getBiggest() + 1;; i++) {
            if (!isDivisible(i)) {
                PRIME.add(i);
                break;
            }
        }
    }

    /**
     * Returns true if <code>number</code> is divisble by any of current
     * prime numbers
     */
    private static boolean isDivisible(long number) {
        for (int i = 0; PRIME.get(i) * PRIME.get(i) <= number; i++) {
            if (number % PRIME.get(i) == 0) {
                return true;
            }
        }
        return false;
    }

    private static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else {
            return pow(a, b - 1) * a;
        }
    }
}