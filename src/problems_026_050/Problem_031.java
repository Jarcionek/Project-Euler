package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_031 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;

        System.out.println(f(5));

        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int f(int amount) {
        /*if (amount == 1) {
            return 1;
        } else if (amount == 2) {
            return 2*f(1);
        } else if (amount == 4) {
            return 2*f(2);
        } else if (amount == 5) {
            return 1 + f(4);
        } else {
            return f(amount - 1);
        }*/
        return - 1;
    }
}
