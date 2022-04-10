package model;

import java.util.Scanner;

public class MineField {
    /**
     * The number of rows.
     */
    private final int myN;
    /**
     * The number of columns.
     */
    private final int myM;
    /**
     * The Covered version of the minefield.
     */
    private final CoveredField myCoveredField;
    /**
     * The Swept version of the minefield.
     */
    private final SweptField mySweptField;

    /**
     * Builds a minefield using a given size.
     * @param theN the number of rows.
     * @param theM the number of columns.
     */
    public MineField(final int theN, final int theM, final Scanner theConsole) {
        myN = theN;
        myM = theM;
        myCoveredField = new CoveredField(myN, myM, theConsole);
        mySweptField = new SweptField(myCoveredField);
        for (int i = 0; i < myN; i++) {
            System.out.println(mySweptField.rowToString(i));
        }
    }

}
