package problems_026_050;

import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_032 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        /*
         * if product has 8 digits, then multiplicand and multiplier have the
         * most one digit what gives maximum product 9*8 = 72
         *
         * if product has 7 digits, then product is for sure smaller than
         98*9 = 882, still much less than 10^7
         *
         * product 6 digits, is smaller than 98*98 = 9604
         *
         * product 5 digits, is smaller than 987*98 = 96726
         */
//        for (int number = 1; number < 96726; number++) {
        for (int number = 1; number < 96726; number++) {
            String t = "" + number;
            boolean ok = false;
            long div = 0; //progress monitor
            for (long e : Prime.getAllDivisors(number)) {
                if (isOk("" + number + e + (number/e))) {
                    div = e;
                    ok = true;
                    break;
                }
            }
            if (ok) {
                System.out.println(number + " = " + div + " x " + (number/div));
                result += number;
            }
        }

        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static boolean isOk(String number) {
        boolean ok = true;
        if (number.length() < 9) {
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
