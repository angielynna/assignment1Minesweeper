package individualsolutions.minesweeperleylaahmed;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MinesweeperLeylaAhmed {
    public static void main(final String[] theArgs) {
        final ArrayList<char[][]> fields = new ArrayList<>();
        final Scanner scr = new Scanner(System.in);
        String line;

        int rows = scr.nextInt();
        int cols = scr.nextInt();

        while (rows != 0 && cols != 0) {
            final char[][] minefield = new char[rows][cols];

            for (int i = 0; i < minefield.length; i++) {

                line = scr.next();

                for (int j = 0; j < minefield[i].length; j++) {

                    minefield[i][j] = line.charAt(j);
                }

            }

            fields.add(minefield);
            rows = scr.nextInt();
            cols = scr.nextInt();

        }

        scr.close();

        printMineFields(fields);

    }

    private static int showMineField(final int theRow, final int theCol,
                                     final char[][] theField) {
        int count = 0;

        if (theField[theRow][theCol] != '*') {

            theField[theRow][theCol] = (char) count;

            if (theRow > 0 && theField[theRow - 1][theCol] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }

            if (theRow < theField.length - 1
                    && theField[theRow + 1][theCol] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }

            if (theCol > 0 && theField[theRow][theCol - 1] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }

            if (theCol < theField[theRow].length - 1
                    && theField[theRow][theCol + 1] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }

            if (theRow > 0 && theCol > 0
                    && theField[theRow - 1][theCol - 1] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }

            if (theRow > 0 && theCol < theField[theRow].length - 1
                    && theField[theRow - 1][theCol + 1] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }

            if (theRow < theField.length - 1 && theCol > 0
                    && theField[theRow + 1][theCol - 1] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }
            if (theRow < theField.length - 1 && theCol < theField[theRow].length - 1
                    && theField[theRow + 1][theCol + 1] == '*') {
                count++;
                theField[theRow][theCol] = (char) count;
            }

        }
        return count;

    }

    private static void printMineFields(final ArrayList<char[][]> theFields) {
        final PrintStream console = new PrintStream(System.out);
        System.setOut(console);

        for (int i = 1; i <= theFields.size(); i++) {

            console.println("Field #" + i + ":");

            for (int row = 0; row < theFields.get(i - 1).length; row++) {

                for (int col = 0; col < theFields.get(i - 1)[0].length; col++) {

                    if (theFields.get(i - 1)[row][col] != '*') {

                        console.print(showMineField(row, col, theFields.get(i - 1)));

                    } else {

                        console.print("*");
                    }
                }

                console.println();
            }
            console.println();
        }
    }
}
