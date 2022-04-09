package Model;

public class SweptField {
    final int myN, myM;
    final int[][] mySweptField;

    public SweptField(final CoveredField theCoveredField) {
        myN = theCoveredField.getN();
        myM = theCoveredField.getM();
        mySweptField = new int[myN][myM];

        for(int i = 0; i < myN; i++) {
            for (int j = 0; j < myM; j++) {
                //Top-Left Corner
                if (j == 0 && i == 0) {
                    
                }
            }
        }
    }
}
