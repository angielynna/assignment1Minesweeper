package officialsolution;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Displays minesweeper minefield with all adjacency values and bombs.
 *
 * @author Angelynna Pyeatt
 * @author Amtoj Kaur
 * @author Leyla Ahmed
 * @version October 11, 2022
 */

public class OfficialMinesweeper {
    /**
     * Main method.
     * Takes in a file name from the console as program arguments and displays
     * the correct minefield.
     *
     * @param theArgs
     * @throws Exception
     */
    public static void main(final String[] theArgs) {
        final Scanner sc = new Scanner(System.in);
        int numFields = 0;
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        if(indicesOK(rows, cols)) {
            while(rows != 0 && cols != 0) {
                numFields++;
                final char[][] input = new char[rows][cols];
                for (int i = 0; i < rows; i++) {
                    final char[] line = sc.next().toCharArray();
                    for (int j = 0; j < cols; j++) {
                        if(j > 0 && i > 0) {
                            input[i][j] = line[j];
                        }
                    }
                }

                final char[][] filledMineField = fillMineField(input);
                display(filledMineField, numFields);

                rows = sc.nextInt();
                cols = sc.nextInt();
            }
        } else {
            throw new IllegalArgumentException("Row or column "
                    + "value is not accepted");
        }
    }

    /**
     * Displays the correct output to System.out.
     *
     * @param theFilledMine
     * @param theNumFields
     */
    public static void display(final char[][] theFilledMine,
                               final int theNumFields) {
        if(theNumFields <= 0) {
            throw new IllegalArgumentException("Illegal number of fields.");
        }

        final PrintStream console = new PrintStream(System.out);
        System.setOut(console);

        console.println("Field #" + theNumFields + ":");
        for (char[] chars : theFilledMine) {
            for (int j = 0; j < theFilledMine[0].length; j++) {
                console.print(chars[j]);
            }
            console.println();
        }
    }

    /**
     * Confirms that the row and column value is valid.
     *
     * @param theRow
     * @param theCol
     * @return boolean
     */
    public static boolean indicesOK(final int theRow, final int theCol) {
        return theRow > 0 && theRow <= 100
                && theCol > 0 && theCol <= 100;
    }

    /**
     * Fills minefield with adjacency.
     *
     * @param theMineField
     * @return numFields
     */
    public static char[][] fillMineField(final char[][] theMineField) {
        final char[][] numFields = new
                char[theMineField.length][theMineField[0].length];
        for(int i = 0; i < theMineField.length; i++) {
            for(int j = 0; j < theMineField[0].length; j++) {
                if(theMineField[i][j] == '*') {
                    numFields[i][j] = '*';
                } else {
                    numFields[i][j] = getAdjacency(i, j, theMineField);
                }
            }
        }
        return numFields;
    }

    public static char getAdjacency(final int theRow, final int theCol,
                                    final char[][] theField) {
        final int count = 0;

        if (theField[theRow][theCol] != '*') {

            if (theRow > 0 && theField[theRow - 1][theCol] == '*') {
                count++;
            }

            if (theRow < theField.length - 1
                    && theField[theRow + 1][theCol] == '*') {
                count++;
            }

            if (theCol > 0 && theField[theRow][theCol - 1] == '*') {
                count++;
            }

            if (theCol < theField[theRow].length - 1
                    && theField[theRow][theCol + 1] == '*') {
                count++;
            }

            if (theRow > 0 && theCol > 0 && theField[theRow - 1][theCol - 1] == '*') {
                count++;
            }

            if (theRow > 0 && theCol < theField[theRow].length - 1
                    && theField[theRow - 1][theCol + 1] == '*') {
                count++;
            }

            if (theRow < theField.length - 1 && theCol > 0
                    && theField[theRow + 1][theCol - 1] == '*') {
                count++;
            }
            if (theRow < theField.length - 1 && theCol < theField[theRow].length - 1
                    && theField[theRow + 1][theCol + 1] == '*') {
                count++;
            }

        }
        return (char) (count + '0');

    }
}
