package problems_026_050;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.util.HashMap;
import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_049 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("-> " + calculate());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static long calculate() {
        long result = 0;
        
        Prime.sieve(10000);
        int startIndex = 0;
        while (Prime.get(startIndex) < 1000) {
            startIndex++;
        }
        int endIndex = 0;
        while (Prime.get(endIndex) < 10000) {
            endIndex++;
        }
        endIndex--;
        
        long one, two, three;
        while (startIndex < endIndex) {
            for (int difference = 1; difference < 5000; difference++) {
                one = Prime.get(startIndex);
                two = one + difference;
                three = two + difference;
                if (three > 10000) {
                    continue;
                }
                if (Prime.isPrime(two) && Prime.isPrime(three)
                        && isPermutation(one, two) && isPermutation(one, three)) {
                    System.out.println(one + " " + two + " " + three);
                }
            }
            startIndex++;
        }
        
        return result;
    }
    
    private static HashMap<Character, Integer> x = new HashMap<Character, Integer>();
    private static HashMap<Character, Integer> y = new HashMap<Character, Integer>();
    private static boolean isPermutation(long one, long two) {
        x.clear();
        y.clear();
        for (char c : ("" + one).toCharArray()) {
            if (x.get(c) == null) {
                x.put(c, 1);
            } else {
                x.put(c, x.get(c) + 1);
            }
        }
        for (char c : ("" + two).toCharArray()) {
            if (y.get(c) == null) {
                y.put(c, 1);
            } else {
                y.put(c, y.get(c) + 1);
            }
        }
        return x.equals(y);
    }
}
