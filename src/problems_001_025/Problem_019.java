package problems_001_025;

import java.util.Calendar;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_019 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;
        
        result = calculate();
        
        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static int calculate() {
        int result = 0;
        Calendar c = Calendar.getInstance();
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 0; month < 12; month++) {
                c.set(year, month, 1);
                if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    result++;
                }
            }
        }
        return result;
    }
}
