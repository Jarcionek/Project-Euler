package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_009 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int a = 1; a < 500; a++) {
            for (int b = 1; b < 500; b++) {
                int c = (1000-a-b);
                if (a*a + b*b == c*c) {
                    System.out.println(a*b*c);
                }
            }
        }
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
