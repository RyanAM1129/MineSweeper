package Model;

public class SweptField {
    /*
    * myN is the number or rows
    * myM is the number of columns
    */
    final int myN, myM;
    /*
    * mySweptField is the array representation of the minefield
    */
    final int[][] mySweptField;

    public SweptField(final CoveredField theCoveredField) {
        myN = theCoveredField.getN();
        myM = theCoveredField.getM();
        mySweptField = new int[myN][myM];

        for(int i = 0; i < myN; i++) {
            for (int j = 0; j < myM; j++) {
                //i is the row and j is the column

                //Top-Left Corner
                if (j == 0 && i == 0) {
                    //Checks spot to the right
                    if (theCoveredField.getSpot(i, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-right
                    if (theCoveredField.getSpot(i + 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Top-Right Corner
                else if (i == 0 && j == (myM - 1)) {
                    //Checks spot to the left
                    if (theCoveredField.getSpot(i, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-left
                    if (theCoveredField.getSpot(i + 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Bottom-Left Corner
                else if (i == (myN - 1) && j == 0) {
                    //Checks spot to the top
                    if (theCoveredField.getSpot(i - 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top-right
                    if (theCoveredField.getSpot(i - 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the right
                    if (theCoveredField.getSpot(i, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Bottom-Right Corner
                else if (i == (myN - 1) && j == (myM - 1)) {
                    //Checks spot to the left
                    if (theCoveredField.getSpot(i, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top-left
                    if (theCoveredField.getSpot(i - 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top
                    if (theCoveredField.getSpot(i - 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Top Row
                else if (i == 0) {
                    //Checks spot to the left
                    if (theCoveredField.getSpot(i, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-left
                    if (theCoveredField.getSpot(i + 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-right
                    if (theCoveredField.getSpot(i + 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the right
                    if (theCoveredField.getSpot(i, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Left Column
                else if (j == 0) {
                    //Checks spot to the top
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top-right
                    if (theCoveredField.getSpot(i - 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the right
                    if (theCoveredField.getSpot(i, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-right
                    if (theCoveredField.getSpot(i + 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Right Column
                else if (j == (myM - 1)) {
                    //Checks spot to the top
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top-left
                    if (theCoveredField.getSpot(i - 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the left
                    if (theCoveredField.getSpot(i, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-left
                    if (theCoveredField.getSpot(i + 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Bottom Row
                else if (i == (myN - 1)) {
                    //Checks spot to the left
                    if (theCoveredField.getSpot(i, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top-left
                    if (theCoveredField.getSpot(i - 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top-right
                    if (theCoveredField.getSpot(i - 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the right
                    if (theCoveredField.getSpot(i, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                }
                //Everything Else
                else {
                    //Checks spot to the top-left
                    if (theCoveredField.getSpot(i - 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the top-right
                    if (theCoveredField.getSpot(i - 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the right
                    if (theCoveredField.getSpot(i, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-right
                    if (theCoveredField.getSpot(i + 1, j + 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom
                    if (theCoveredField.getSpot(i + 1, j) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the bottom-left
                    if (theCoveredField.getSpot(i + 1, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                    //Checks spot to the left
                    if (theCoveredField.getSpot(i, j - 1) == '*') {
                        mySweptField[i][j]++;
                    }
                }
            }
        }
    }

    public String rowToString(final int theN) {
        StringBuilder myStringBuilder = new StringBuilder();
        for (int myValue : mySweptField[theN]) {
            myStringBuilder.append(myValue);
        }
        return myStringBuilder.toString();
    }
}
