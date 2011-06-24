package utilities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author Jaroslaw Pawlak
 */
public class Utilities {
    private Utilities() {};

    /**
     * Returns i'th permutation of n elements.<p>
     * if i = 0 then array is {0, 1, 2, ... n-2, n-1}<p>
     * if i = 1 then array is {0, 1, 2, ... n-1, n-2}<p>
     * if i = n-1 then array is {n-1, n-2, ... 2, 1, 0}
     */
    public static int[] getPermutation(int n, int i) {
        if (n <= 0 || i < 0 || i >= f(n)) {
            throw new IllegalArgumentException("n = " + n + ", i = " + i);
        }

        List<Integer> list = new LinkedList<Integer>();
        List<Integer> order = new ArrayList<Integer>(n);
        for (int j = 0; j < n; j++) {
            list.add(j);
            order.add(0);
        }

        int r = 0;
        for (int j = 0; j < n; j++) {
            while (r + f(list.size() - 1 - j) <= i) {
                r += f(list.size() - 1 - j);
                order.set(j, order.get(j) + 1);
            }
        }

        int[] result = new int[n];
        for (int j = 0; j < n; j++) {
            result[j] = list.remove((int) order.get(j));
        }

        return result;
    }

    /**
     * i = 0 - no rotation<p>
     * i = 0: 0123456789<p>
     * i = 1: 1234567890<p>
     */
    public static int[] getRotation(int n, int i) {
        if (n <= 0) {
            throw new IllegalArgumentException("n = " + n + ", i = " + i);
        }
        i %= n;

        Vector<Integer> vec = new Vector<Integer>();
        for (int j = 0; j < n; j++) {
            vec.add(j);
        }

        while (i > 0) {
            vec.add(vec.get(0));
            vec.removeElementAt(0);
            i--;
        }

        int[] result = new int[n];
        for (int j = 0; j < n; j++) {
            result[j] = vec.remove(0);
        }

        return result;
    }

    public static int[] getDigits(long number) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        while (number > 0) {
            a.add((int) (number % 10));
            number /= 10;
        }
        int[] r = new int[a.size()];
        for (int i = 0; i < r.length; i++) {
            r[r.length - 1 - i] = a.get(i);
        }
        return r;
    }

    //binary numbers in problem36


    /**
     * factorial
     */
    public static int f(int n) {
        return n == 0? 1 : n * f(n-1);
    }

    /**
     * a ^ b
     */
    public static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        } else if ( b == 1) {
            return a;
        } else if ( b == 2) {
            return a * a;
        } else {
            return ((b & 1) == 1 ? a : 1) * pow(pow(a, b/2), 2);
        }
    }

    /**
     * a ^ b
     */
    public static BigInteger pow(BigInteger a, BigInteger b) {
        BigInteger two = new BigInteger("2");
        if (b.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else if (b.equals(BigInteger.ONE)) {
            return a;
        } else if (b.equals(two)) {
            return a.multiply(a);
        } else if (b.remainder(two).equals(BigInteger.ONE)) {
            return a.multiply(pow(pow(a, b.divide(two)), two));
        } else {
            return pow(pow(a, b.divide(two)), two);
        }
    }

    /**
     * (a ^ b) % l
     */
    public static int pow(int a, int b, int l) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
            result %= l;
        }
        return result;
    }

    /**
     * (a ^ b) % l
     */
    public static long pow(int a, int b, long l) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
            result %= l;
        }
        return result;
    }

    /**
     *     n!
     * ---------
     * r! (n-r)!
     */
    public static long C(int n, int r) {
        if (n > 20) { //!!!!!
            System.err.println("possible overflow in Utilities.C(int, int)");
        }
        int smaller, bigger;
        if (n > n - r) {
            bigger = n;
            smaller = n - r;
        } else {
            bigger = n - r;
            smaller = n;
        }
//TODO kurwa! doesnt work!
        long result = 1;
        for (int i = smaller + 1; i <= n; i++) {
            result *= i;
        }
        for (int i = 2; i <= bigger; i++) {
            result /= i;
        }
        return result;
    }

    public static boolean isPandigital(String number, boolean oneToNine) {
        boolean ok = true;
        if (oneToNine && number.length() != 9) {
            return false;
        }
        for (char j = '1'; j < number.length() + '1'; j++) {
            if (number.indexOf("" + j) == -1
                    || number.indexOf("" + j) != number.lastIndexOf("" + j)) {
                ok = false;
                break;
            }
        }
        return ok;
    }
}