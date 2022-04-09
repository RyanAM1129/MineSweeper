package Model;

import Controller.Converter;

import java.util.Scanner;

public class CoveredField {
    final int myN, myM;
    char[][] myField;

    public CoveredField(final int theN, final int theM) {
        myN = theN;
        myM = theM;
        myField = new char[myN][myM];
        Scanner myConsole = new Scanner(System.in);
        String myCurrentLine;
        char[] myCurrentRow;
        Converter myConverter = new Converter();

        for (int i = 0; i < theN; i++) {
            myCurrentLine = myConsole.nextLine();
            myCurrentRow = myConverter.convertRow(myCurrentLine);
            myField[i] = myCurrentRow;
        }
    }

    public char getSpot(final int theN, final int theM) {
        return myField[theN][theM];
    }

    public int getN() {
        return myN;
    }

    public int getM() {
        return myM;
    }
}
