package problems_051_075;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_079 {
    private static final String[] keylogs = {"319", "680", "180", "690", "129",
        "620", "762", "689", "762", "318", "368", "710", "720", "710", "629",
        "168", "160", "689", "716", "731", "736", "729", "316", "729", "729",
        "710", "769", "290", "719", "680", "318", "389", "162", "289", "162",
        "718", "729", "319", "790", "680", "890", "362", "319", "760", "316",
        "729", "380", "319", "728", "716"};

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Set<String> set = new HashSet<String>();
        for (String e : keylogs) {
            set.add(e);
        }

        //TODO doesnt work
        ArrayList<String> list = new ArrayList<String>(set);
        System.out.println(list);
        String result = list.remove(0);
        while (!list.isEmpty()) {
            System.out.println(result);
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                if (result.contains(list.get(i))) {
                    list.remove(i);
                    break;
                }
                //between
                String t = list.get(i).substring(0, 1).concat(list.get(i).substring(2));
                if (result.contains(t)) {
                    result = result.replace(t, list.remove(i));
                    break;
                }
                //after
                t = list.get(i).substring(1, 2);
                if (result.substring(result.length() - 1).equals(t)) {
                    result = result + list.remove(i).substring(2);
                    break;
                }
                //before
                if (result.substring(0, 1).equals(t)) {
                    result = list.remove(i).substring(0, 1) + result;
                    break;
                }
            }
        }


        System.out.println(result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}
