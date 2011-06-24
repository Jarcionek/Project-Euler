package problems_326_350;

import utilities.Utilities;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_336 {
    private static final int N = 11; // number of carriages
    private static final int I = 2011; //i'th lexicographical maximix arrangement

    private static char[] car = new char[N];
    private static char[] temp = new char[N];

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = "";

        for (int i = 0; i < N; i++) {
            car[i] = (char) ('a' + i);
        }

        int max = 2 * N - 3; //number of rotations for maximim arrangement
        int maxR = 0; //number of maximix arrangements

        for (int i = 0; i < Utilities.f(N); i++) { // for each permutation of carriages
            int[] order = Utilities.getPermutation(N, i);
            for (int j = 0; j < temp.length; j++) {
                temp[j] = car[order[j]];
//                System.out.print(temp[j]); // print permutation
            }
//            System.out.print(" - ");

            //algorithm
            int r = 0; //number of rotations for current permutation of carriages
            char carriage = 'a';
            while (carriage - 'a' < N && temp[carriage - 'a'] == carriage) {
                carriage++; //this loop checks how many carriages are already set in proper order
            }

            while (carriage - 'a' < N) {
                if (getIndexOf(carriage) == temp.length - 1) { //if the next carriage is at the end
                    rotate(carriage - 'a'); //rotate from last correctly set carriage till the end
                    r += 1;
                } else {
                    rotate(getIndexOf(carriage)); //rotate from the next carriage till the end - for ABDCE it rotates <C, E>
                    rotate(carriage - 'a'); //rotate from last correctly set carriage till the end - for ABDEC it rotates (B, C>
                    r += 2;
                }
                while (carriage - 'a' < N && temp[carriage - 'a'] == carriage) {
                    carriage++; //this loop checks how many carriages are already set in proper order
                }
            }

//            System.out.println(r);

            if (r == max) {
                maxR++;
                System.out.println(maxR);
            }
            if (maxR == I) {
                for (int j = 0; j < temp.length; j++) {
                    result += car[order[j]];
                }
                break;
            }
        }

        System.out.println(result.toUpperCase());
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * start = 0 - rotate all
     * start = 1 - rotate all but first carriage
     */
    private static void rotate(int start) {
        for (int i = 0; i < (N - start) / 2; i++) {
            char t = temp[start + i];
            temp[start + i] = temp[car.length - 1 - i];
            temp[temp.length - 1 - i] = t;
        }
    }

    private static int getIndexOf(char c) {
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == c) {
                return i;
            }
        }
        return -1;
    }
}