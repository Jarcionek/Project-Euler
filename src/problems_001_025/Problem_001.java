package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_001 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            result += i % 3 == 0 || i % 5 == 0? i : 0;
        }
        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
