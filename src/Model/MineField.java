package Model;

public class MineField{
    private final int myN, myM;
    private final char[][] myField;

    public MineField(final int theN, final int theM) {
        myN = theN;
        myM = theM;
        myField = new char[myN][myM];
    }

    private void buildField(final char[][] theField) {}
}
