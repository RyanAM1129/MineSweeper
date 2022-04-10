package view;

import controller.Converter;
import model.MineField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class Main {
    /**
     * No arg Constructor.
     */
    private Main() { }
    /**
     * Main method for MineSweeper.
     * Need to fix line 35 for second iteration.
     *
     * @param args command arguments for main method.
     */
    public static void main(final String[] args) throws FileNotFoundException {
        Scanner console;
        Converter converter = new Converter();
        MineField myMineField;
        if (args.length == 1){
            console = new Scanner(new File(args[0]));
        } else {
            console = new Scanner(System.in);
        }
        String myCurrentLine = console.nextLine();
        //Stores N in index '0' and 'M' in index 1
        int[] theNAndM = converter.convertFieldSize(myCurrentLine);
        while (theNAndM[0] != 0 && theNAndM[1] != 0) {
            myMineField = new MineField(theNAndM[0], theNAndM[1], console);
            myCurrentLine = console.nextLine();
            theNAndM = converter.convertFieldSize(myCurrentLine);
        }
    }
}
