package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_043 {
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("-> " + calculate());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static long calculate() {
        long result = 0;
        
        String str = "";
        for (int i = 0; i <= 9; i++) {
            str += (char) i;
        }
        
        result = x(str, "");
        
        return result;
    }
    
    private static int[] primes = new int[] {-1, 2, 3, 5, 7, 11, 13, 17};
    
    private static long x(String dict, String v) {
        if (dict.length() == 0) {
            for (int i = 1; i <= 7; i++) {
                int n = v.charAt(i) * 100 + v.charAt(i+1) * 10 + v.charAt(i+2);
                if (n % primes[i] != 0) {
                    return 0;
                }
            }
            System.out.println(toString(v));
            long number = 0;
            for (int i = v.length() - 1; i >= 0; i--) {
                number += 1L * v.charAt(i)
                        * utilities.Utilities.pow(10, v.length() - 1 - i);
            }
            return number;
        }
        
        long result = 0;
        for (int i = 0; i < dict.length(); i++) {
            result += x(dict.substring(0, i) + dict.substring(i+1),
                    v + dict.charAt(i));
        }
        return result;
    }
    
    private static String toString(String x) {
        String str = "";
        for (char c : x.toCharArray()) {
            str += (int) c;
        }
        return str;
    }
}
