package problems_026_050;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_031 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("-> " + calculate());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    
    private static final int AMOUNT = 200;
    
    private static long calculate() {
        return f(0, 1);
    }
    
    private static int f(int amount, int min) {
        if (amount > AMOUNT) {
            return 0;
        } else if (amount == AMOUNT) {
            return 1;
        }
        int result = 0;
        switch (min) {
            case 1: result += f(amount + 1, 1);
            case 2: result += f(amount + 2, 2);
            case 5: result += f(amount + 5, 5);
            case 10: result += f(amount + 10, 10);
            case 20: result += f(amount + 20, 20);
            case 50: result += f(amount + 50, 50);
            case 100: result += f(amount + 100, 100);
            case 200: result += f(amount + 200, 200);
        }
        
        return result;
    }
}
