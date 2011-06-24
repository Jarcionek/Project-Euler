package problems_301_325;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_314 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        double max = 125;
        int maxi = 0;


        for (int r = 0; r <= 250; r++) {
            double area = Math.PI * r * r;
            area += (500 - 2 * r) * r;
            area += (500 - 2 * r) * (500 - 2 * r);
            double perimeter = 2 * Math.PI * r;
            perimeter += 4 * (500 - 2 * r);
            System.out.println(r + "\t" + (area/perimeter));
        }

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
