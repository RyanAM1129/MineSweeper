package view;

import controller.Converter;
import model.MineField;

import java.util.Scanner;

public final class Main {
    /**
     * No arg Constructor.
     */
    private Main() { }
    /**
     * Main method for MineSweeper.
     * @param args command arguments for main method.
     */
    public static void main(final String[] args) {
        Scanner console = new Scanner(System.in);
        Converter converter = new Converter();
        MineField myMineField;
        String myCurrentLine = console.nextLine();
        //Stores N in index '0' and 'M' in index 1
        int[] theNAndM = converter.convertFieldSize(myCurrentLine);
        while (theNAndM[0] != 0 && theNAndM[1] != 0) {
            myMineField = new MineField(theNAndM[0], theNAndM[1]);
            myCurrentLine = console.nextLine();
            theNAndM = converter.convertFieldSize(myCurrentLine);
        }
    }
}
