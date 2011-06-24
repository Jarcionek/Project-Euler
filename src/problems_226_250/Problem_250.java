package problems_226_250;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Jaroslaw Pawlak
 */
public class Problem_250 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        //find all remainders
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= 1000; i++) {
            set.add(utilities.Utilities.pow(i, i, 250));
        }

        //store remainders in an array
        int[] remainders = new int[set.size()];
        int[] amount = new int[set.size()];
        int h = 0;
        for (int e : set) {
            remainders[h++] = e;
        }

        //find amounts
        for (int i = 1; i <= 1000; i++) { //for first 1000
            int r = utilities.Utilities.pow(i, i, 250);
            for (int j = 0; j < remainders.length; j++) {
                if (remainders[j] == r) {
                    amount[j]++;
                }
            }
        }

        for (int i = 0; i < amount.length; i++) { //for first 250000
            amount[i] *= 250;
        }

        for (int i = 1; i <= 250; i++) { //for 250,001 - 250,250
            int r = utilities.Utilities.pow(i, i, 250);
            for (int j = 0; j < remainders.length; j++) {
                if (remainders[j] == r) {
                    amount[j]++;
                }
            }
        }

        System.out.print("    ");
        for (int i = 0; i < remainders.length; i++) {
            System.out.print(remainders[i] + "  ");
        }
        System.out.println();
        for (int i = 0; i < amount.length; i++) {
            System.out.print(amount[i] + " ");
        }
        System.out.println();
        
        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
