package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_040 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int r = 1;

        String x = "";

        //TODO sucks but works :P 10 minutes ;)

        for (int i = 1; i <= 200000; i++) {
            x += i;
        }
        r *= x.charAt(0) - 48;
        r *= x.charAt(9) - 48;
        r *= x.charAt(99) - 48;
        r *= x.charAt(999) - 48;
        r *= x.charAt(9999) - 48;
        r *= x.charAt(99999) - 48;
        r *= x.charAt(999999) - 48;

        System.out.println(r);

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
