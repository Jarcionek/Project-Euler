package problems_026_050;

import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_026 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("-> " + calculate());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static long calculate() {
        long result = 0;
        
        Prime.sieve(1000);
        for (long n : Prime.allPrimeNumbers()) {
            if (n >= 1000) {
                break;
            }
            
            String fraction = fraction(n);
            String part = fraction.substring(100, 150);
            int start = fraction.indexOf(part, 101);
            if (start - 100 > result) {
                result = n;
            }
        }
        
        
        return result;
    }
    
    private static String fraction(long n) {
        String result = "";
        long temp = 10;
        while (result.length() < 2000) {
            result += temp / n;
            temp = (temp % n) * 10;
        }
        return result;
    }
    
    
}
