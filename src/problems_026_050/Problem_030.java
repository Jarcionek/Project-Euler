package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_030 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int result = 0;

        for (int i = 10; i < 354295; i++) {
            int[] digits = new int[6];

            digits[5] = i % 10;
            digits[4] = (i % 100 - digits[5]) / 10;
            digits[3] = (i % 1000 - digits[4]) / 100;
            digits[2] = (i % 10000 - digits[3]) / 1000;
            digits[1] = (i % 100000 - digits[2]) / 10000;
            digits[0] = (i % 1000000 - digits[1]) / 100000;

            int r = 0;
            for (int j = 0; j < 6; j++) {
                r += digits[j] * digits[j] * digits[j] * digits[j] * digits[j];
            }

            if (r == i) {
                result += r;
                System.out.println(r);
            }
        }

        System.out.println("-> " + result);

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
