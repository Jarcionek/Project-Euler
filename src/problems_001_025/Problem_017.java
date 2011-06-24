package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_017 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long result = 0;
        result += 9 * "one".length();
        result += 9 * "two".length();
        result += 9 * "three".length();
        result += 9 * "four".length();
        result += 9 * "five".length();
        result += 9 * "six".length();
        result += 9 * "seven".length();
        result += 9 * "eight".length();
        result += 9 * "nine".length();
        result += "ten".length();
        result += "eleven".length();
        result += "twelve".length();
        result += "thirteen".length();
        result += "fourteen".length();
        result += "fifteen".length();
        result += "sixteen".length();
        result += "seventeen".length();
        result += "eighteen".length();
        result += "nineteen".length();
        result += 10 * "twenty".length();
        result += 10 * "thirty".length();
        result += 10 * "fourty".length();
        result += 10 * "fifty".length();
        result += 10 * "sixty".length();
        result += 10 * "seventy".length();
        result += 10 * "eighty".length();
        result += 10 * "ninty".length();

        result *= 10;

        result += 100 * ("one".length() + "hundred".length() + "and".length());
        result += 100 * ("two".length() + "hundred".length() + "and".length());
        result += 100 * ("three".length() + "hundred".length() + "and".length());
        result += 100 * ("four".length() + "hundred".length() + "and".length());
        result += 100 * ("five".length() + "hundred".length() + "and".length());
        result += 100 * ("six".length() + "hundred".length() + "and".length());
        result += 100 * ("seven".length() + "hundred".length() + "and".length());
        result += 100 * ("eight".length() + "hundred".length() + "and".length());
        result += 100 * ("nine".length() + "hundred".length() + "and".length());
        result -= 9 * "and".length();

        result += "one".length() + "thousand".length();

        System.out.println(result);

        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
