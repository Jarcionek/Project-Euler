package utilities;

import java.util.ArrayList;

/**
 * @author Jaroslaw Pawlak
 */
public class FunctionPeriodFinder {
    private static ArrayList<Integer> values = new ArrayList<Integer>();
    private static ArrayList<Integer> period = new ArrayList<Integer>();
    private static int periodStart = 0;

    public static void addValue(int value) {
        values.add(value);
    }

    public static void findPeriod() {

    }

    public static int getPeriodLength() {
        return period.size();
    }

}
