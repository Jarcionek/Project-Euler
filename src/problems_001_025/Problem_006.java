package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_006 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int a = 0;
        int b = 0;
        for (int i = 1; i <= 100; i++) {
            a += i*i;
            b += i;
        }
        b = b*b;
        System.out.println(b - a);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
