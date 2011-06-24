package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_045 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        int n = 144;
        long h;
        double t, p;
        while (true) {
//            System.out.println(n);
            h = 2 * n * n - n;
            t = -0.5d + Math.sqrt(0.25d + 2*h);
            if (t % 1 < 0.0000001) {
                p = 0.5d + Math.sqrt(0.25d + 6*h);
                p /= 3;
                if (p % 1 < 0.0000001) {
                    result = (long) (t * (t + 1) / 2);
                    break;
                }
            }
            n++;
        }


        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
