package problems_076_100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_079 {
    private static final String LOGS[] = {
        "319", "680", "180", "690", "129", "620", "762", "689", "762", "318",
        "368", "710", "720", "710", "629", "168", "160", "689", "716", "731",
        "736", "729", "316", "729", "729", "710", "769", "290", "719", "680",
        "318", "389", "162", "289", "162", "718", "729", "319", "790", "680",
        "890", "362", "319", "760", "316", "729", "380", "319", "728", "716",
//        "126"
    };

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = "";

        Set<Integer> digits = new HashSet<Integer>(10);
        Set<String> logs = new HashSet<String>();
        for (String e : LOGS) {
            if (logs.add(e)) {
                digits.add(e.charAt(0) - '0');
                digits.add(e.charAt(1) - '0');
                digits.add(e.charAt(2) - '0');
            }
        }

        ArrayList<Node> nodes = new ArrayList<Node>(digits.size() * 2);
        for (Integer e : digits) {
            nodes.add(new Node(e));
        }

        for (String e : logs) {
            for (int i = 0; i < 3; i++) {
                int c = e.charAt(i) - '0';
                for (Node n : nodes) {
                    if (n.value == c) {
                        if (i == 0) {
                            n.after.add(e.charAt(1) - '0');
                            n.after.add(e.charAt(2) - '0');
                        } else if (i == 1) {
                            n.before.add(e.charAt(0) - '0');
                            n.after.add(e.charAt(2) - '0');
                        } else { // i == 2
                            n.before.add(e.charAt(0) - '0');
                            n.before.add(e.charAt(1) - '0');
                        }
                    }
                }
            }
        }

        String passLeft = "", passRight = "";
        Node left, right;
        while (true) {
            left = null;
            right = null;
            for (Node n : nodes) { // find end nodes
                if (n.before.isEmpty()) {
                    left = n;
//                    System.out.println("LEFT: " + left);
                }
                if (n.after.isEmpty()) {
                    right = n;
//                    System.out.println("RIGHT: " + right);
                }
            }

            if (left == null && right == null) {
                break;
            }
            if (left != null) {
                passLeft = passLeft + left.value;
            }
            if (right != null) {
                passRight = right.value + passRight;
            }

            for (Node n : nodes) {
                if (left != null) {
                    n.before.remove(left.value);
                }
                if (right != null) {
                    n.after.remove(right.value);
                }
            }
            nodes.remove(left);
            nodes.remove(right);
        }

        if (!nodes.isEmpty()) {
            System.out.println("Something went wrong! Remaining nodes:");
            result = passLeft + "_" + passRight;
            for (Node n : nodes) {
                System.out.println(n);
            }
        } else {
            result = passLeft + passRight;
        }

        System.out.println("-> " + result);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
}

class Node {
    int value;
    Set<Integer> before;
    Set<Integer> after;
    Node(int current) {
        this.value = current;
        this.before = new HashSet<Integer>();
        this.after = new HashSet<Integer>();
    }
    void removeInteger(int integer) {
        before.remove(integer);
        after.remove(integer);
    }
    @Override
    public String toString() {
        String text = "Node: [";
        boolean cut = false;
        for (Integer e : before) {
            text += e + ",";
            cut = true;
        }
        if (cut) {
            text = text.substring(0, text.length() - 1);
        }
        text += "] <- ";
        text += value;
        text += " -> [";
        cut = false;
        for (Integer e : after) {
            text += e + ",";
            cut = true;
        }
        if (cut) {
            text = text.substring(0, text.length() - 1);
        }
        text += "]";
        return text;
    }
}