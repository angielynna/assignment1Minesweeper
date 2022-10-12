package individualsolutions.minesweeperamtojkaur;


import java.io.PrintStream;
import java.util.Scanner;

public class MineSweeperAmtojKaur {
    public static void main(final String[] theArgs) {
        final Scanner scanner = new Scanner(System.in);
        final int numFields = 0;
        final int row = scanner.nextInt();
        final int col = scanner.nextInt();
        mineSweeper(row, col, numFields, scanner);
    }

    private static void mineSweeper(final int theRow, final int theCol, final int theNumFields,
                                    final Scanner theScanner) {
        int numFields = theNumFields;
        int row = theRow;
        int col = theCol;
        while (!(row == 0 || col == 0)) {
            numFields++;
            final char[][] field = new char[row + 1][col + 1];
            for (int i = 0; i < row + 1; i++) {
                final char[] line = theScanner.nextLine().toCharArray();
                for (int j = 0; j < col; j++) {
                    if (j > 0 && i > 0) {
                        field[i][j] = line[j];
                    }
                }
            }
            final char[][] filledMineField = fillField(field);
            displayOut(filledMineField, numFields);
            row = theScanner.nextInt();
            col = theScanner.nextInt();

        }
    }

    private static void displayOut(final char[][] theFilledMine,
                                   final int theNumFields) {
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
    private static char[][] fillField(final char[][] theMineField) {
        final char[][] numFields = new
                char[theMineField.length][theMineField[0].length];
        int i = 0;
        while (i < theMineField.length) {
            int j = 0;
            while (j < theMineField[0].length) {
                if (theMineField[i][j] == '*') {
                    numFields[i][j] = '*';
                } else {
                    numFields[i][j] = adjacent(theMineField, i, j);
                }
                j++;
            }
            i++;
        }
        return numFields;
    }


    private static char adjacent(final char[][] theField, final int theRow, final int theCol) {
        int count = 0;
        if (validValue(theField, theRow - 1, theCol - 1)
                && theField[theRow - 1][theCol - 1] == '*') {
            count++;
        }
        if (validValue(theField, theRow - 1, theCol)
                && theField[theRow - 1][theCol] == '*') {
            count++;
        }
        if (validValue(theField, theRow - 1, theCol + 1)
                && theField[theRow - 1][theCol + 1] == '*') {
            count++;
        }
        //current row:
        if (validValue(theField, theRow, theCol - 1)
                && theField[theRow][theCol - 1] == '*') {
            count++;
        }
        if (validValue(theField, theRow, theCol + 1)
                && theField[theRow][theCol + 1] == '*') {
            count++;
        }
        //row below:
        if (validValue(theField, theRow + 1, theCol - 1)
                && theField[theRow + 1][theCol - 1] == '*') {
            count++;
        }
        if (validValue(theField, theRow + 1, theCol)
                && theField[theRow + 1][theCol] == '*') {
            count++;
        }
        if (validValue(theField, theRow + 1, theCol + 1)
                && theField[theRow + 1][theCol + 1] == '*') {
            count++;
        }
        //System.out.println(myCount);
        return (char) (count + '0');

    }

    private static boolean validValue(final char[][] theMineField,
                                       final int theRow, final int theCol) {
        return theRow < theMineField.length && theRow >= 0
                && theCol < theMineField[0].length && theCol >= 0;

    }
}
