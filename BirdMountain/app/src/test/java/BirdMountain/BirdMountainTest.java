package BirdMountain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BirdMountainTest {
    private BirdMountain bm = new BirdMountain();

    @Test
    public void peakHeightZeroTest() {
        char mountain[][] = new char[][] {
            "   ".toCharArray(),
            "   ".toCharArray(),
            "   ".toCharArray(),
        };

        assertEquals(0, bm.peakHeight(mountain));
    }

    @Test
    public void heightArrayZeroTest() {
        char mountain[][] = new char[][] {
            "   ".toCharArray(),
            "   ".toCharArray(),
            "   ".toCharArray(),
        };

        int expected[][] = new int[3][3];

        assertArrayEquals(expected, bm.calculateHeightArray(mountain));
    }

    @Test
    public void peakHeightOneTest() {
        char mountain[][] = new char[][] {
            "   ".toCharArray(),
            " ^ ".toCharArray(),
            "   ".toCharArray(),
        };

        assertEquals(1, bm.peakHeight(mountain));
    }

    @Test
    public void heightArrayOneTest() {
        char mountain[][] = new char[][] {
            "   ".toCharArray(),
            " ^ ".toCharArray(),
            "   ".toCharArray(),
        };

        int expected[][] = new int[3][3];
        expected[1][1] = 1;

        assertArrayEquals(expected, bm.calculateHeightArray(mountain));
    }

    @Test
    public void peakHeightTwoTest() {
        char mountain[][] = new char[][] {
            "^^^".toCharArray(),
            "^^^".toCharArray(),
            "^^^".toCharArray(),
        };

        assertEquals(2, bm.peakHeight(mountain));
    }

    @Test
    public void heightArrayTwoTest() {
        char mountain[][] = new char[][] {
            "^^^".toCharArray(),
            "^^^".toCharArray(),
            "^^^".toCharArray(),
        };

        int expected[][] = {
            {1, 1, 1},
            {1, 2, 1},
            {1, 1, 1}
        };

        assertArrayEquals(expected, bm.calculateHeightArray(mountain));
    }

    @Test
    public void peakHeightThreeTest() {
        char[][] mountain = {
            "^^^^^^        ".toCharArray(),
            " ^^^^^^^^     ".toCharArray(),
            "  ^^^^^^^     ".toCharArray(),
            "  ^^^^^       ".toCharArray(),
            "  ^^^^^^^^^^^ ".toCharArray(),
            "  ^^^^^^      ".toCharArray(),
            "  ^^^^        ".toCharArray()
        }; 

        assertEquals(3, bm.peakHeight(mountain));
    }

    @Test
    public void heightArrayThreeTest() {
        char[][] mountain = {
            "^^^^^^        ".toCharArray(),
            " ^^^^^^^^     ".toCharArray(),
            "  ^^^^^^^     ".toCharArray(),
            "  ^^^^^       ".toCharArray(),
            "  ^^^^^^^^^^^ ".toCharArray(),
            "  ^^^^^^      ".toCharArray(),
            "  ^^^^        ".toCharArray()
        };

        int expected[][] = {
            {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 3, 3, 2, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 3, 3, 2, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertArrayEquals(expected, bm.calculateHeightArray(mountain));
    }


    /*********************************************
     * Stolen Test Cases -> CodeWars
     ********************************************/
    @Test
    public void zero() {
        char[][] mountain = {
        "      ".toCharArray(),
        "      ".toCharArray(),
        "      ".toCharArray()
        };      
        assertEquals(0, bm.peakHeight(mountain));
    }    
    
    @Test
    public void rock() {
        char[][] mountain = {
        "           ".toCharArray(),
        "           ".toCharArray(),
        "           ".toCharArray(),
        "      ^    ".toCharArray()
        };      
        assertEquals(1, bm.peakHeight(mountain));
    }    

    @Test
    public void one() {
        char[][] mountain = {
        "      ".toCharArray(),
        "  ^^  ".toCharArray(),
        "      ".toCharArray()
        };      
        assertEquals(1, bm.peakHeight(mountain));
    }    
    
    @Test
    public void two() {
        char[][] mountain = {
        "^^^^^".toCharArray(),
        " ^^^ ".toCharArray(),
        "^^^^^".toCharArray()
        };      
        assertEquals(2, bm.peakHeight(mountain));
    }      
    
    @Test
    public void twins() {
        char[][] mountain = {
        "^^^^^       ".toCharArray(),
        "^^^^^       ".toCharArray(),
        "^^^^^       ".toCharArray(),
        "            ".toCharArray(),
        "     ^^^^^^^".toCharArray(),
        "     ^^^^^^^".toCharArray(),
        "     ^^^^^^^".toCharArray(),
        "     ^^^^^^^".toCharArray(),
        "     ^^^^^^^".toCharArray(),
        "     ^^^^^^^".toCharArray(),
        "     ^^^^^^^".toCharArray()        
        };      
        assertEquals(4, bm.peakHeight(mountain));
    }      
    
    @Test
    public void misc1() {
        char[][] mountain = {
        "^^   ^^^  ^^".toCharArray(),
        "^ ^^  ^^^   ".toCharArray(),
        "  ^^^   ^^  ".toCharArray(),
        "    ^^ ^^   ".toCharArray(),
        "   ^  ^     ".toCharArray(),
        "    ^^      ".toCharArray(),
        " ^^^^^^^^   ".toCharArray(),
        "  ^^^^^^^^  ".toCharArray(),
        " ^^ ^^^   ^^".toCharArray(),
        "^^^    ^^ ^^".toCharArray(),
        "     ^^^^^^^".toCharArray()        
        };      
        assertEquals(2, bm.peakHeight(mountain));
    }      
    
    @Test
    public void misc2() {
        char[][] mountain = {
        "     ^^^^^^".toCharArray(),
        " ^^^^^^^^  ".toCharArray(),                                        
        "^^^^^^^^^  ".toCharArray(),
        "  ^^^^^^^^ ".toCharArray(),
        "  ^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^".toCharArray(),
        "  ^^^^^^^^^".toCharArray(),
        "  ^^^^^^^^ ".toCharArray(),
        "  ^^^^^^^  ".toCharArray(),
        "  ^^^^^^   ".toCharArray(),
        "   ^^^^^^  ".toCharArray(),
        "    ^^^^^  ".toCharArray(),
        "      ^^   ".toCharArray()
        };      
        assertEquals(5, bm.peakHeight(mountain));
    }          
    
    @Test
    public void plateau() {
        char[][] mountain = {
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
        };      
        assertEquals(11, bm.peakHeight(mountain));
    }          
    
    @Test
    public void volcano() {
        char[][] mountain = {
        "      ^^^^^^^^^      ".toCharArray(),
        "    ^^^^^^^^^^^^^    ".toCharArray(),
        "  ^^^^^^^^^^^^^^^^^  ".toCharArray(),
        " ^^^^^^^     ^^^^^^^ ".toCharArray(),
        "^^^^^^^       ^^^^^^^".toCharArray(),
        "^^^^^^^       ^^^^^^^".toCharArray(),
        "^^^^^^^       ^^^^^^^".toCharArray(),
        " ^^^^^^^     ^^^^^^^ ".toCharArray(),
        "  ^^^^^^^^^^^^^^^^^  ".toCharArray(),
        "    ^^^^^^^^^^^^^    ".toCharArray(),
        "      ^^^^^^^^^      ".toCharArray(),
        };      
        assertEquals(4, bm.peakHeight(mountain));
    }  
}
