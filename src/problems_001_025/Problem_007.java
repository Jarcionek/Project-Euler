package problems_001_025;

import java.util.ArrayList;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_007 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        prime.add(2);
        for (int i = 0; i < 10000; i++) {
            addNew();
        }
        System.out.println(getBiggest());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static ArrayList<Integer> prime = new ArrayList<Integer>();
    private static void addNew() {
        for (int i = getBiggest() + 1;; i++) {
            if (!isDivisible(i)) {
                prime.add(i);
                break;
            }
        }
    }
    private static int getBiggest() {
        return prime.get(prime.size() - 1);
    }
    /**
     * Returns true if <code>number</code> is divisble by any of current
     * prime numbers
     */
    private static boolean isDivisible(int number) {
        for (int i = 0; i < prime.size(); i++) {
            if (number % prime.get(i) == 0) {
                return true;
            }
        }
        return false;
    }
}
