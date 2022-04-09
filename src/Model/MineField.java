package Model;

public class MineField{
    private final int myN, myM;
    private final CoveredField myCoveredField;
    private final SweptField mySweptField;

    public MineField(final int theN, final int theM) {
        myN = theN;
        myM = theM;
        myCoveredField = new CoveredField(myN, myM);
        mySweptField = new SweptField(myCoveredField);
        for (int i = 0; i < myN; i++) {
            System.out.println(mySweptField.rowToString(i));
        }
    }

}
