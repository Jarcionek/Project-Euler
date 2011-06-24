package problems_026_050;

import java.util.Stack;
import java.util.Vector;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_036 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long result = 0;
        for (int n = 1; n < 1000000; n++) {
            boolean pal = true;
            int x = n;

            Vector<Integer> vec1 = new Vector<Integer>(6);
            while (x > 0) {
                vec1.add(x % 10);
                x /= 10;
            }

            for (int i = 0; i < vec1.size(); i++) {
                if (vec1.get(i) != vec1.get(vec1.size() - 1 - i)) {
                    pal = false;
                    break;
                }
            }

            if (!pal) {
                continue;
            }

            //BINARY
            pal = true;
            x = n;

            Vector<Boolean> vec2 = new Vector<Boolean>(32);
            while (x > 0) {
                vec2.add((x & 1) == 1);
                x = x >>> 1;
            }

            for (int i = 0; i < vec2.size(); i++) {
                if (vec2.get(i) != vec2.get(vec2.size() - 1 - i)) {
                    pal = false;
                    break;
                }
            }

            if (pal) {
                System.out.println(n);
                result += n;
            }
        }

        System.out.println("-> " + result);

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}