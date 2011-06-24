package problems_051_075;

import utilities.Utilities;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_053 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = Utilities.C(23, 10);

        for (int i = 1; i < 23; i++) {
            result = 1;
            for (int j = 1; j <= i; j++) {
                result *= j;
            }
            System.out.println(i + " " + result);
        }

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
