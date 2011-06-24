package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_005 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int N = 20;
        long x = 1;
        while (true) {
            boolean found = true;
            for (int i = 2; i <= N; i++) {
                if (x % i != 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                break;
            } else {
                x++;
            }
        }
        System.out.println("-> " + x);
        System.out.println("-> " + 2*2*2*2*3*3*5*7*11*13*17*19);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
