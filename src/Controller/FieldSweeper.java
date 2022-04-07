package Controller;

public class FieldSweeper {
    private final int myN, myM;
    private final char[][] myMineField;

    public FieldSweeper(final int theN, final int theM) {
        myN = theN;
        myM = theM;
        //temp code
        myMineField = new char[myN][myM];
    }
}
