package problems_176_200;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_191 {
    private static final int DAYS = 4;

    private static int result = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MyString.max = DAYS;
        System.out.println("-> " + count(0, 0, DAYS));
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }

    private static int count(int a, int l, int length) {
        if (a >= 3 || l >= 2) {
            return 0;
        }
        if (length == 0) {
            return 1;
        }
        int r = 0;
        r += count(a + 1, l,     length - 1); // A
        r += count(0,     l + 1, length - 1); // L
        r += count(0,     l,     length - 1); // O
        return r;
    }

    private static int[] b = {1, 0, 0, 0, 0, 0};

    public static long x(int days) {
            for (int i = 1; i <= days; i++) {
                int[] t = new int[6];
                t[0] = b[0] + b[1] + b[2];
                t[1] = b[0];
                t[2] = b[1];
                t[3] = b[0] + b[1] + b[2] + b[3] + b[4] + b[5];
                t[4] = b[3];
                t[5] = b[4];
                b = t;
            }
            return b[3];
    }

    private static void init(MyString x) {
        if (x.containsTripleA()) {
            // no prize
        } else if (x.containsDoubleL()) {
            // no prize
        } else {
            if (x.length() == DAYS) {
                result++;
            } else {
                init(x.concat('A'));
                init(x.concat('O'));
                init(x.concat('L'));
            }
        }
    }
}

class MyString {
    public static int max = 30;

    private char[] values = new char[max];
    private boolean containsOneL = false;
    private boolean containsTwoL = false;
    private int last = -1;

    public MyString concat(char value) {
        MyString result = new MyString();
        System.arraycopy(this.values, 0, result.values, 0, this.values.length);
        result.values[result.last = this.last + 1] = value;
        result.containsOneL = this.containsOneL;
        result.containsTwoL = this.containsTwoL;
        if (value == 'L') {
           if (result.containsOneL) {
               result.containsTwoL = true;
           } else {
               result.containsOneL = true;
           }
        }
        return result;
    }

    public boolean containsDoubleL() {
        return containsTwoL;
    }

    public boolean containsTripleA() {
        return last >= 2 && values[last] == 'A' && values[last-1] == 'A' && values[last-2] == 'A';
    }

    public int length() {
        return last + 1;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i <= last; i++) {
            result += values[i];
        }
        return result;
    }
}
