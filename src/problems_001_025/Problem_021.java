package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_021 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long r = 0;
        
        for (int i = 1; i < 10000; i++) {
            for (int j = i + 1; j < 10000; j++) {
                if (d(i, j) == j && d(j, i) == i) {
                    r += i + j;
                    System.out.println("found: " + i + " " + j);
                }
            }
        }
        
        System.out.println(r);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static int d(int n, int max) {
        int result = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result += i + (i == n / i? 0 : n / i);
                if (result > max) {
                    return -1;
                }
            }
        }
        return result;
    }
}
