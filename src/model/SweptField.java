package model;

/**
 * ADT representing a minefield that has been "swept".
 */
public class SweptField {
    /**
     * The number of rows.
     */
    private final int myN;
    /**
     * The number of columns.
     */
    private final int myM;
    /**
    * 2-Dimensional array representation of the swept minefield.
    */
    private final char[][] mySweptField;

    /**
     * Constructor that creates a Swept minefield from a given
     * Covered Field.
     * @param theCoveredField the given Covered minefield.
     */
    public SweptField(final CoveredField theCoveredField) {
        myN = theCoveredField.getN();
        myM = theCoveredField.getM();
        mySweptField = theCoveredField.getField();

        for (int i = 0; i < myN; i++) {
            for (int j = 0; j < myM; j++) {
                //i is the row and j is the column
                if (theCoveredField.getSpot(i, j) != '*') {
                    mySweptField[i][j] = '0';
                    mineSweep(i, j, theCoveredField);
                }
            }
        }
    }

    /**
     * Given a 'n' and 'm' value, you check all locations adjacent
     * to the spot in a given CoveredField.
     *
     * @param theN the row index.
     * @param theM  the column index.
     * @param theCoveredField the covered field being evaluated.
     */
    private void mineSweep(final int theN, final int theM,
                           final CoveredField theCoveredField) {
        //This does not work for a 1x1 array, Need to fix
        if (theN == 0 && theM == 0) {
            //Top-Left Corner
            checkRight(theN, theM, theCoveredField);
            checkBottomRight(theN, theM, theCoveredField);
            checkBottom(theN, theM, theCoveredField);
        } else if (theN == 0 && theM == (myM - 1)) {
            //Top-Right Corner
            checkLeft(theN, theM, theCoveredField);
            checkBottomLeft(theN, theM, theCoveredField);
            checkBottom(theN, theM, theCoveredField);
        } else if (theN == (myN - 1) && theM == 0) {
            //Bottom-Left Corner
            checkTop(theN, theM, theCoveredField);
            checkTopRight(theN, theM, theCoveredField);
            checkRight(theN, theM, theCoveredField);
        } else if (theN == (myN - 1) && theM == (myM - 1)) {
            //Bottom-Right Corner
            checkLeft(theN, theM, theCoveredField);
            checkTopLeft(theN, theM, theCoveredField);
            checkTop(theN, theM, theCoveredField);
        } else if (theN == 0) {
            //Top Row
            checkLeft(theN, theM, theCoveredField);
            checkBottomLeft(theN, theM, theCoveredField);
            checkBottom(theN, theM, theCoveredField);
            checkBottomRight(theN, theM, theCoveredField);
            checkRight(theN, theM, theCoveredField);
        } else if (theM == 0) {
            //Left Column
            checkTop(theN, theM, theCoveredField);
            checkTopRight(theN, theM, theCoveredField);
            checkRight(theN, theM, theCoveredField);
            checkBottomRight(theN, theM, theCoveredField);
            checkBottom(theN, theM, theCoveredField);
        } else if (theM == myM - 1) {
            //Right Column
            checkTop(theN, theM, theCoveredField);
            checkTopLeft(theN, theM, theCoveredField);
            checkLeft(theN, theM, theCoveredField);
            checkBottomLeft(theN, theM, theCoveredField);
            checkBottom(theN, theM, theCoveredField);
        } else if (theN == myN - 1) {
            //Bottom Row
            checkLeft(theN, theM, theCoveredField);
            checkTopLeft(theN, theM, theCoveredField);
            checkTop(theN, theM, theCoveredField);
            checkTopRight(theN, theM, theCoveredField);
            checkRight(theN, theM, theCoveredField);
        } else {
            //Everything Else
            checkTopLeft(theN, theM, theCoveredField);
            checkTop(theN, theM, theCoveredField);
            checkTopRight(theN, theM, theCoveredField);
            checkRight(theN, theM, theCoveredField);
            checkBottomRight(theN, theM, theCoveredField);
            checkBottom(theN, theM, theCoveredField);
            checkBottomLeft(theN, theM, theCoveredField);
            checkLeft(theN, theM, theCoveredField);
        }
    }

    /**
     * Checks the spot above a given [n][m] position in a given
     * Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkTop(final int theN, final int theM,
                          final CoveredField theCoveredField) {
        if (theN - 1 >= 0 && theCoveredField.getSpot(theN - 1, theM) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Checks the spot below a given [n][m] position in a given
     * Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkBottom(final int theN, final int theM,
                          final CoveredField theCoveredField) {
        if (theN + 1 < theCoveredField.getN()
                && theCoveredField.getSpot(theN + 1, theM) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Checks the spot to the right of a given [n][m] position
     * in a given Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkRight(final int theN, final int theM,
                             final CoveredField theCoveredField) {
        if (theM + 1 < theCoveredField.getM()
                && theCoveredField.getSpot(theN, theM + 1) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Checks the spot to the left of a given [n][m] position
     * in a given Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkLeft(final int theN, final int theM,
                            final CoveredField theCoveredField) {
        if (theM - 1 >= 0 && theCoveredField.getSpot(theN, theM - 1) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Checks the spot to the top left of a given [n][m] position
     * in a given Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkTopLeft(final int theN, final int theM,
                           final CoveredField theCoveredField) {
        if (theN - 1 >= 0 && theM - 1 >= 0
                && theCoveredField.getSpot(theN - 1, theM - 1) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Checks the spot to the top right of a given [n][m] position
     * in a given Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkTopRight(final int theN, final int theM,
                              final CoveredField theCoveredField) {
        if (theN >= 0 && theM + 1 < theCoveredField.getM()
                && theCoveredField.getSpot(theN - 1, theM + 1) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Checks the spot to the bottom right of a given [n][m] position
     * in a given Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkBottomRight(final int theN, final int theM,
                               final CoveredField theCoveredField) {
        if (theN + 1 < theCoveredField.getN()
                && theM + 1 < theCoveredField.getM()
                && theCoveredField.getSpot(theN + 1, theM + 1) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Checks the spot to the bottom left of a given [n][m] position
     * in a given Covered Field to see if it has a mine. If it does, it
     * will increase the value at the [theN][theM] location.
     * @param theN the row index.
     * @param theM the column index.
     * @param theCoveredField the given Covered Field.
     */
    private void checkBottomLeft(final int theN, final int theM,
                                  final CoveredField theCoveredField) {
        if (theN + 1 < theCoveredField.getN() && theM - 1 >= 0
                && theCoveredField.getSpot(theN + 1, theM - 1) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Returns a given row as a String.
     * @param theN the row index.
     * @return String representation of given row.
     */
    public String rowToString(final int theN) {
        final StringBuilder myStringBuilder = new StringBuilder();
        for (final char myValue : mySweptField[theN]) {
            myStringBuilder.append(myValue);
        }
        return myStringBuilder.toString();
    }
}
