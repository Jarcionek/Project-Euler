package problems_026_050;

import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_041 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        Prime.sieve(100000000); //max 8 digits
        String t = "";
        for (int i = 0; i < Prime.getNumberOfPrimes(); i++) {
            t = "" + Prime.get(i);
            boolean ok = true;
            for (char j = '1'; j < t.length() + '1'; j++) {
                if (!t.contains("" + j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println(result = Prime.get(i));
            }
        }

        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
