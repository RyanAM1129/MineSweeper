package Controller;

public class Converter {
    public int[] convertFieldSize(String theFieldSize) {
        int myN, myM;

        myN = Integer.parseInt(theFieldSize.charAt(0) + "");
        myM = Integer.parseInt((theFieldSize.charAt(theFieldSize.length() - 1) + ""));

        return new int[] {myN, myM};
    }

    public char[] convertRow(final String theLine) {
        return theLine.toCharArray();
    }
}
