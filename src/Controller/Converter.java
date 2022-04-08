package Controller;

public class Converter {
    public int[] convertFieldSize(String theFieldSize) {
        int myN, myM;

        myN = theFieldSize.charAt(0);
        myM = theFieldSize.charAt(theFieldSize.length() - 1);

        return new int[] {myN, myM};
    }

    public char[] convertRow(final String theLine) {
        return theLine.toCharArray();
    }
}
