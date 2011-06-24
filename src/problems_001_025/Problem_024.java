package problems_001_025;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_024 {
    private static final int N = 1000000;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> order = new ArrayList<Integer>(10);
        for (int i = 0; i <= 9; i++) {
            list.add(i);
            order.add(0);
        }
        int r = 0;
        for (int i = 0; i <= 9; i++) {
            while (r + f(list.size() - 1 - i) < N) {
                r += f(list.size() - 1 - i);
                order.set(i, order.get(i) + 1);
            }
        }

        for (int i = 0; i <= 9; i++) {
            System.out.print(list.remove((int) order.get(i)));
        }
        System.out.println();

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static int f(int n) {
        return n == 0? 1 : n * f(n-1);
    }
}
