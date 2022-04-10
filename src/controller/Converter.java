package controller;

public class Converter {
    /**
     * Default Constructor.
     */
    public Converter() { }
    /**
     * Converts a given Field Size String into two int
     * values and returns them as an array.
     * @param theFieldSize the given Field Size String.
     * @return the array containing the N and M values respectively.
     */
    public int[] convertFieldSize(final String theFieldSize) {
        final int myN;
        final int myM;
        String mySubString1 = "-1";
        String mySubString2 = "-1";

        for (int i = 0; i < theFieldSize.length(); i++) {
            if(theFieldSize.charAt(i) == ' ') {
                mySubString1 = theFieldSize.substring(0, i);
                mySubString2 = theFieldSize.substring(i + 1);
                break;
            }
        }

        myN = Integer.parseInt(mySubString1);
        myM = Integer.parseInt(mySubString2);

        return new int[] {myN, myM};
    }

    /**
     * Converts a given row String into an array of characters.
     * @param theLine the given row String.
     * @return character array containing all characters from
     * given String.
     */
    public char[] convertRow(final String theLine) {
        return theLine.toCharArray();
    }
}
