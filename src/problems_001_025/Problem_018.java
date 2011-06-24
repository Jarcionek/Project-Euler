package problems_001_025;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_018 {
    private static int[][] x = {{75},
{95, 64},
{17, 47, 82},
{18, 35, 87, 10},
{20, 04, 82, 47, 65},
{19, 01, 23, 75, 03, 34},
{88, 02, 77, 73, 07, 63, 67},
{99, 65, 04, 28, 06, 16, 70, 92},
{41, 41, 26, 56, 83, 40, 80, 70, 33},
{41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
{63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
{04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23}};

    private static int max = 0;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = x.length - 2; i >= 0; i--) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] += x[i+1][j] > x[i+1][j+1] ? x[i+1][j] : x[i+1][j+1];
            }
        }
        System.out.println(x[0][0]);

//        x(0, 0, 0);
//        System.out.println(max);
        System.out.println("done in " + (System.currentTimeMillis() - start) + "ms");
    }
    /**
     * first invocation: x(0, 0, 0);
     */
    private static void x(int row, int inRow, int resultFromPrevious) {
        if (row == x.length) {
            if (resultFromPrevious > max) {
                max = resultFromPrevious;
            }
        } else {
            System.out.println(row + " " + inRow + " " + (resultFromPrevious + x[row][inRow]));
            x(row + 1, inRow, resultFromPrevious + x[row][inRow]);
            x(row + 1, inRow + 1, resultFromPrevious + x[row][inRow]);
        }
    }
}
