package View;

import Controller.Converter;
import Controller.FieldSweeper;
import Model.MineField;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Converter converter = new Converter();
        FieldSweeper fieldSweeper;
        MineField myMineField;
        //Stores N in index '0' and 'M' in index 1
        int[] theNAndM = converter.convertFieldSize(console.nextLine());
        while (theNAndM[0] !=0 && theNAndM[1] != 0) {
            myMineField = new MineField(theNAndM[0], theNAndM[1]);
            System.out.println(myMineField);

        }
    }
}
