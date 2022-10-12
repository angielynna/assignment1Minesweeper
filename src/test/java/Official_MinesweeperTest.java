import org.junit.Test;
import org.testng.AssertJUnit;

import java.io.FileNotFoundException;

import static officialsolution.Official_Minesweeper.*;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class Official_MinesweeperTest {

    /**
     * Tests for an illegal row value,
     * expects a false
     */
    @Test
    public void indecesRowTestZero() {
        AssertJUnit.assertEquals(false, indicesOK(0, 100));


    }

    /**
     * Tests for an illegal row value,
     * expects a false
     */
    @Test
    public void indecesRowTest101() {
        assertEquals(false, indicesOK(101,100));

    }

    /**
     * Tests for an illegal column value,
     * expects a false
     */
    @Test
    public void indicesColumnTestZero() {
        assertEquals(false, indicesOK(100,0));

    }

    /**
     * Tests for an illegal column value,
     * expects a false
     */
    @Test
    public void indicesColumnTest101() {
        assertEquals(false, indicesOK(100,101));

    }

    /**
     * Tests for an max allowed row and column value,
     * expects a true
     */
    @Test
    public void indicesColumnTestValidMax() {
        assertEquals(true, indicesOK(100,100));

    }

    /**
     * Tests for an min allowed row and column value,
     * expects a true
     */
    @Test
    public void indicesColumnTestValidMin() {
        assertEquals(true, indicesOK(1,1));

    }

    /**
     * Tests for random allowed row and column value,
     * expects a true
     */
    @Test
    public void indicesColumnTestValidValue() {
        assertEquals(true, indicesOK(24,85));

    }

    /**
     * sends an invalid number of fields to display method, expects
     * IllegalArgumentException
     */
    @Test
    public void displayTest() {
        char[][] test = new char[][]{{'0'}};
        assertThrows(IllegalArgumentException.class, () -> {
            display(test, 0);
        });
    }

    /**
     * Sends fillMineField with a random test maze,
     * expects correct result maze
     */
    @Test
    public void fillMineFieldTest() {
        char[][] test = new char[][] {{'.', '.'},
                {'*', '.'},
                {'.', '.'}};
        char[][] result = new char[][] {{'1', '1'},
                {'*', '1'},
                {'1', '1'}};
        assertArrayEquals(result, fillMineField(test));
    }

    /**
     * Tests getAdjacency method for minimum adjacency number,
     * expects '0'
     */
    @Test
    public void getAdjacencyZeroTest() {
        char[][] test = new char[][] {{'.', '.'}};
        assertEquals('0', getAdjacency(0, 0, test));
    }

    /**
     * Tests getAdjacency method for maximum adjacency number,
     * expects '8'
     */
    @Test
    public void getAdjacencyEightTest() {
        //for 8
        char[][] test = new char[][] {{'*', '*', '*'},
                {'*', '.', '*'},
                {'*', '*', '*'}};
        assertEquals('8', getAdjacency(1, 1, test));
    }

}
