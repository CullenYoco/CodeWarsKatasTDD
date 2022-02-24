package BirdMountain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class BirdMountainRiverTest {
    @Test
    public void noRiverGroundLevelTest() {
        char[][] terrain = {
            "   ".toCharArray(),
            "   ".toCharArray(), 
            "   ".toCharArray() 
        };

        assertArrayEquals(new int[]{9, 9, 9, 9}, BirdMountainRiver.dryGround(terrain));
    }

    @Test
    public void noRiverMountainTest() {
        char[][] terrain = {
            "^^^^^^        ".toCharArray(),
            " ^^^^^^^^     ".toCharArray(),
            "  ^^^^^^^     ".toCharArray(),
            "  ^^^^^       ".toCharArray(),
            "  ^^^^^^^^^^^ ".toCharArray(),
            "  ^^^^^^      ".toCharArray(),
            "  ^^^^        ".toCharArray()
        }; 

        assertArrayEquals(new int[]{98, 98, 98, 98}, BirdMountainRiver.dryGround(terrain));
    }

    @Test
    public void riverOnFlatGroundTest() {
        char[][] terrain = {
            "   ".toCharArray(),
            "---".toCharArray(), 
            "   ".toCharArray() 
        };

        assertArrayEquals(new int[]{6, 0, 0, 0}, BirdMountainRiver.dryGround(terrain));
    }
}
