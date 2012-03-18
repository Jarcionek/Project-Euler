package problems_351_375;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_375 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("-> " + calculate());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static long calculate() {
        long result = 0;
        
        
        
        
        
        return result;
    }
    
    private static long A(int i, int j) {
        long min = Long.MAX_VALUE;
        
        return min;
    }
    
    private static long S(int n) {
        if (n == 0) {
            return 290797L;
        } else {
            long a = S(n - 1) % 50515093;
            return a * a % 50515093;
        }
    }
    
    
}
