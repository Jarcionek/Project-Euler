package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_033 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        double result = 1;

        for (double a = 10; a < 100; a++) {
            for (double b = a + 1; b < 100; b++) {
                String nominator = "" + a;
                String denominator = "" + b;
                double a2 = 0;
                double b2 = 0;
                if (nominator.charAt(0) == denominator.charAt(1)) {
                    a2 = nominator.charAt(1) - '0';
                    b2 = denominator.charAt(0) - '0';
                } else if (nominator.charAt(1) == denominator.charAt(0)) {
                    a2 = nominator.charAt(0) - '0';
                    b2 = denominator.charAt(1) - '0';
                }
                if (a2 != 0 && b2 != 0 && b2 > a2) {
                    double t = a / b - a2 / b2;
                    t = t < 0 ? -t : t;
                    if (t < 0.000000001) {
                        result /= a2;
                        result *= b2;
//                        System.out.println(a + "/" + b + " = " + a2 + "/" + b2);
                        System.out.println((int) a + "/" + (int) b + " = " + (int) a2 + "/" + (int) b2);
                    }
                }
            }
        }

        System.out.println("-> " + (int) result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
