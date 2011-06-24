package problems_151_175;

/**
 * @author Jaroslaw Pawlak
 */
public class Problem_173 {
    private static final int TILES = 1000000;

    public static void main(String[] args) {
        int result = 0;
        for (int size = 1; size <= TILES/4 + 1; size++) {
            int tiles = 0;
            for (int layer = 0; layer < (size - 1) / 2; layer++) {
                tiles += fillLayer(size, layer);
                if (tiles > TILES) {
                    break;
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    private static int fillLayer(int length, int layer) {
        return (length - 2 * layer - 1) * 4;
    }
}
