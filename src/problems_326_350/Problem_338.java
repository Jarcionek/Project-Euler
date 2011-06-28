package problems_326_350;

import java.util.HashSet;
import java.util.Set;
import utilities.Prime;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_338 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int N = 15;
//        for (int i = 1; i <= N; i++) {
//            System.out.printf(i + ". ");
//            for (int j = 1; j <= i; j++) {
//                System.out.print(F(j, i) + " ");
//            }
//            System.out.println();
//        }
        print(20);

        System.out.println();
        System.out.println(G(N));
        
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static int F(int w, int h) { // h >= w
        if ((w & 1) == 1 && (h & 1) == 1) { //both are odd
            return 0;
        } else if (h < w) {
            return F(h, w);
        }
        int result = 0;
        for (int x = 1; x * x <= w * h; x++) {
            if (w * h % x != 0 || x == w) {
                continue;
            }
            if (h % (h - x) == 0 || x % (x - w) == 0) {
                result++;
            }
        }
        return result;
    }
    private static int G(int n) {
        int result = 0;
        for (int h = 1; h <= n; h++) {
            for (int w = h; w <= n; w++) {
                result += F(w, h);
            }
        }
        return result;
    }
    private static void print(int n) {
        for (int i = 1; i <= n; i++) {
                int r = 0;
                for (int j = 0; j < i; j++) {
                        System.out.print("\t");
                }

                for (int j = i; j <= n; j++) {
                        System.out.print(F(i, j) + "\t");
                        r += F(i, j);
                }
                System.out.println(i + "\t" + r);
        }

        System.out.print("\t");

        for (int i = 1; i <= n; i++) {
                System.out.print(i + "\t");
        }

        System.out.println("\t");
        System.out.print("\t");

        for (int i = 1; i <= n; i++) {
                int r = 0;
                for (int j = 1; j <= i; j++) {
                        r += F(j, i);
                }
                System.out.print(r + "\t");
        }
    }
}
