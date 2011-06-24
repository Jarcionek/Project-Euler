package problems_026_050;

import utilities.Utilities;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_038 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        for (int number = 1; number < 100000; number++) {
            String t = "" + number;
            int n = 2;
            while (t.length() < 9) {
                t += number * n;
                n++;
            }
            if (Utilities.isPandigital(t, true)) {
                if (Integer.parseInt(t) > result) {
                    result = Integer.parseInt(t);
                }
            }
        }

        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
