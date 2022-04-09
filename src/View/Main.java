package View;

import Controller.Converter;
import Model.MineField;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
