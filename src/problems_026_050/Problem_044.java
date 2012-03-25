package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_044 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("-> " + calculate());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static long calculate() {
        int[] pentagonals = new int[100000];
        for (int i = 1; i < pentagonals.length; i++) {
            pentagonals[i] = i * (3*i - 1) / 2;
        }
        
        /*
         * 'b' is difference and should be the smallest
         * numbers are 'a' and 'c'
         * a + b = c
         * c + a = d
         */
        
        for (int b = 1; b < pentagonals.length; b++) {
            for (int a = 1; a < pentagonals.length; a++) {
                int c = getN(pentagonals[b] + pentagonals[a]);
                if (c == -1) {
                    continue;
                }
                int d = getN(pentagonals[c] + pentagonals[a]);
                if (d == -1) {
                    continue;
                }
                return pentagonals[b];
            }
        }
        
        return -1;
    }
    
    private static int getN(int pentagonal) {
        double sqrt = Math.sqrt(0.25d + 6 * pentagonal);
        if (sqrt % 0.5d != 0) {
            return -1;
        }
        int a = (int) (0.5d + sqrt);
        if (a % 3 != 0) {
            return -1;
        }
        return a / 3;
    }
}
