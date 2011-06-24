package problems_026_050;

import java.util.Vector;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_034 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long result = 0;
        for (int n = 10; n < 25401610; n++) { // 7 * f(9) + 1
            int x = n;
            Vector<Integer> vec = new Vector<Integer>(6);
            while (x > 0) {
                vec.add(x % 10);
                x /= 10;
            }

            int temp = 0;
            for (int i = 0; i < vec.size(); i++) {
                temp += f(vec.get(i));
                if (temp > n) {
                    break;
                }
            }
            if (temp == n) {
                System.out.println(n);
                result += n;
            }
        }

        System.out.println("-> " + result);

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    private static int f(int n) {
        return n == 0? 1 : n * f(n-1);
    }
}
