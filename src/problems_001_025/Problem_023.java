package problems_001_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_023 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = calculate();
        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static List<Integer> list = new ArrayList<Integer>();
    
    private static long calculate() {
        long result = 0;
        
        for (int i = 1; i <= 500000; i++) {
            if (d(i) > i && d(i) <= 28123) {
                list.add(i);
            }
        }
        Collections.sort(list);
        
        outer:
        for (int number = 1; number <= 28123; number++) {
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int sum = list.get(left) + list.get(right);
                if (sum == number) {
                    continue outer;
                } else if (sum < number) {
                    left++;
                } else { //sum > number
                    right--;
                }
            }
            System.out.println("adding: " + number);
            result += number;
        }
        
        return result;
    }
    
    private static int d(int n) {
        int result = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result += i + (i == n / i? 0 : n / i);
            }
        }
        return result;
    }
}
