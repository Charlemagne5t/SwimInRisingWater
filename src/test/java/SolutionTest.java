import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void swimInWaterTest1() {
        int[][] grid = {
                {0, 2},
                {1, 3}
        };
        int expected = 3;
        int actual = new Solution().swimInWater(grid);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void swimInWaterTest2() {
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        int expected = 16;
        int actual = new Solution().swimInWater(grid);

        Assertions.assertEquals(expected, actual);
    }
}
