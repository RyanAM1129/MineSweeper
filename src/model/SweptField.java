package model;

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
    private final int[][] mySweptField;

    /**
     * Constructor that creates a Swept minefield from a given
     * Covered Field.
     * @param theCoveredField the given Covered minefield.
     */
    public SweptField(final CoveredField theCoveredField) {
        myN = theCoveredField.getN();
        myM = theCoveredField.getM();
        mySweptField = new int[myN][myM];

        for (int i = 0; i < myN; i++) {
            for (int j = 0; j < myM; j++) {
                //i is the row and j is the column
                if (j == 0 && i == 0) {
                    //Top-Left Corner
                    checkRight(i, j, theCoveredField);
                    checkBottomRight(i, j, theCoveredField);
                    checkBottom(i, j, theCoveredField);
                } else if (i == 0 && j == (myM - 1)) {
                    //Top-Right Corner
                    checkLeft(i, j, theCoveredField);
                    checkBottomLeft(i, j, theCoveredField);
                    checkBottom(i, j, theCoveredField);
                } else if (i == (myN - 1) && j == 0) {
                    //Bottom-Left Corner
                    checkTop(i, j, theCoveredField);
                    checkTopRight(i, j, theCoveredField);
                    checkRight(i, j, theCoveredField);
                } else if (i == (myN - 1) && j == (myM - 1)) {
                    //Bottom-Right Corner
                    checkLeft(i, j, theCoveredField);
                    checkTopLeft(i, j, theCoveredField);
                    checkTop(i, j, theCoveredField);
                } else if (i == 0) {
                    //Top Row
                    checkLeft(i, j, theCoveredField);
                    checkBottomLeft(i, j, theCoveredField);
                    checkBottom(i, j, theCoveredField);
                    checkBottomRight(i, j, theCoveredField);
                    checkRight(i, j, theCoveredField);
                } else if (j == 0) {
                    //Left Column
                    checkTop(i, j, theCoveredField);
                    checkTopRight(i, j, theCoveredField);
                    checkRight(i, j, theCoveredField);
                    checkBottomRight(i, j, theCoveredField);
                    checkBottom(i, j, theCoveredField);
                } else if (j == (myM - 1)) {
                    //Right Column
                    checkTop(i, j, theCoveredField);
                    checkTopLeft(i, j, theCoveredField);
                    checkLeft(i, j, theCoveredField);
                    checkBottomLeft(i, j, theCoveredField);
                    checkBottom(i, j, theCoveredField);
                } else if (i == (myN - 1)) {
                    //Bottom Row
                    checkLeft(i, j, theCoveredField);
                    checkTopLeft(i, j, theCoveredField);
                    checkTop(i, j, theCoveredField);
                    checkTopRight(i, j, theCoveredField);
                    checkRight(i, j, theCoveredField);
                } else {
                    //Everything Else
                    checkTopLeft(i, j, theCoveredField);
                    checkTop(i, j, theCoveredField);
                    checkTopRight(i, j, theCoveredField);
                    checkRight(i, j, theCoveredField);
                    checkBottomRight(i, j, theCoveredField);
                    checkBottom(i, j, theCoveredField);
                    checkBottomLeft(i, j, theCoveredField);
                    checkLeft(i, j, theCoveredField);
                }
            }
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
        if (theCoveredField.getSpot(theN - 1, theM) == '*') {
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
        if (theCoveredField.getSpot(theN + 1, theM) == '*') {
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
        if (theCoveredField.getSpot(theN, theM + 1) == '*') {
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
        if (theCoveredField.getSpot(theN, theM - 1) == '*') {
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
        if (theCoveredField.getSpot(theN - 1, theM - 1) == '*') {
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
        if (theCoveredField.getSpot(theN - 1, theM + 1) == '*') {
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
        if (theCoveredField.getSpot(theN + 1, theM + 1) == '*') {
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
        if (theCoveredField.getSpot(theN + 1, theM - 1) == '*') {
            mySweptField[theN][theM]++;
        }
    }

    /**
     * Returns a given row as a String.
     * @param theN the row index.
     * @return String representation of given row.
     */
    public String rowToString(final int theN) {
        StringBuilder myStringBuilder = new StringBuilder();
        for (int myValue : mySweptField[theN]) {
            myStringBuilder.append(myValue);
        }
        return myStringBuilder.toString();
    }
}
