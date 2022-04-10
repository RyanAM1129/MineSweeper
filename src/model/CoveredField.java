package model;

import controller.Converter;

import java.util.Scanner;

public class CoveredField {
    /**
     * The number of rows.
     */
    private final int myN;
    /**
     * The number of columns.
     */
    private final int myM;
    /**
     * The 2-dimensional character array representation
     * of the Covered Mine Field.
     */
    private final char[][] myField;
    /**
     * Ensures all input gets read from command line argument.
     */
    private final Scanner myConsole;

    /**
     * Constructor for CoveredField using given size.
     * @param theN the number of rows.
     * @param theM the number of columns.
     */
    public CoveredField(final int theN, final int theM, final Scanner theConsole) {
        myN = theN;
        myM = theM;
        myField = new char[myN][myM];
        myConsole = theConsole;
        String myCurrentLine;
        char[] myCurrentRow;
        Converter myConverter = new Converter();

        for (int i = 0; i < theN; i++) {
            myCurrentLine = myConsole.nextLine();
            myCurrentRow = myConverter.convertRow(myCurrentLine);
            myField[i] = myCurrentRow;
        }
    }

    /**
     * Returns the character at given [n][m] position.
     * @param theN The row index.
     * @param theM The column index.
     * @return the character at given [n][m] position.
     */
    public char getSpot(final int theN, final int theM) {
        return myField[theN][theM];
    }

    /**
     * Returns the number of rows.
     * @return the number of rows.
     */
    public int getN() {
        return myN;
    }

    /**
     * Returns the number of columns.
     * @return the number of columns.
     */
    public int getM() {
        return myM;
    }

    /**
     * Returns the 2-dimensional array representing the minefield.
     *
     * @return the 2-dimensional array.
     */
    public char[][] getField() {
        return myField;
    }
}
