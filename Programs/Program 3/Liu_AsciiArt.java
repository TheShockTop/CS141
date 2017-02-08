/***************************************************************
 * file: Liu_AsciiArt.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 3
 * date last modified: 01 - Feb - 2017
 *
 * purpose: This program accepts takes in the file monalisa.txt
 * and parses it into a 2d array. Then we transform it various ways.
 *
 ****************************************************************/
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

class ReadFiles{

    // method: ParseMonaLisa
    // purpose: this method opens the file "monalisa.txt" and parses the chars into
    // a 2d array, which is passed on to different methods in Liu_Ascii class
    public char[][] ParseMonaLisa(){

        try{
            String initalArray0, stringToChar;
            int row, column, monaLisaRow, monaLisacolumn;

            File file = new File("monalisa.txt");
            Scanner scannerMonaLisa = new Scanner(file);
            initalArray0 = scannerMonaLisa.nextLine();
            String[] initalizeMonaLisa = initalArray0.split(" ");
            monaLisaRow = Integer.parseInt(initalizeMonaLisa[0]);
            monaLisacolumn = Integer.parseInt(initalizeMonaLisa[1]);
            char[][] monaLisa = new char[monaLisaRow][monaLisacolumn];

            for (row = 0; row < monaLisa.length; row++) {
                stringToChar = scannerMonaLisa.nextLine();
                char[] arrayCharHolder = stringToChar.toCharArray();

                for (column = 0; column < monaLisa[row].length; column++) {
                    monaLisa[row][column] = arrayCharHolder[column];
                }
            }

            scannerMonaLisa.close();

            return monaLisa;

        } catch (IOException e) {
            System.err.println("File does not exist. Please check your directory for monalisa.txt and try again.");
            System.exit(1);
            char[][] error = {{0,0}};
            return error;
        }
    }
}

public class Liu_AsciiArt{

    // method: DEBUG
    // purpose: just debugging some stuff
    // MUST BE FALSE WHEN OUT :)
    private static boolean DEBUG = false;

    // method: main
    // purpose: if debug is true, then test the debug case, otherwise call ParseMonaLisa from
    // ReadFiles class and pass it on to different methods to transform the array.
    public static void main(String[] args){

        if(DEBUG){

            Debug();
        } else {

            ReadFiles monaLisa = new ReadFiles();

            //Original Text:
            PrintOriginalText(monaLisa.ParseMonaLisa());
            //Transformations:
            PrintTransformation0(monaLisa.ParseMonaLisa());
            PrintTransformation1(monaLisa.ParseMonaLisa());
            PrintTransformation2(monaLisa.ParseMonaLisa());
        }
    }

    // method: Debug
    // purpose: test debug case
    public static void Debug(){
        char[][] debug = {{'F','I','L','E'}, {'W','I','T','H'}, {'S','O','M','E'}, {'M','O','R','E'}, {'I','N','F','O'}};

        //Original Text:
        PrintOriginalText(debug);
        //Transformations:
        PrintTransformation0(debug);
        PrintTransformation1(debug);
        PrintTransformation2(debug);
    }

    // method: PrintOriginalText
    // purpose: Prints out the 2d array in the current form
    public static void PrintOriginalText(char[][] lmao){

        System.out.println("Original Text:");

        for (int i = 0; i < lmao.length; i++){
            System.out.println();
            for(int j = 0; j < lmao[i].length; j++){
                System.out.print(lmao[i][j]);
            }
        }

        System.out.println();
        System.out.println();
    }

    // method: PrintTransformation0
    // purpose: transforms the array to reverse the rows
    public static void PrintTransformation0(char[][] lmao){

        System.out.println("Transformations:");

        for (int i = lmao.length-1; i > -1 ; i-- ){
            System.out.println();
            for (int j = 0; j < lmao[i].length; j++){
                System.out.print(lmao[i][j]);
            }
        }

        System.out.println();
        System.out.println();
    }

    // method: PrintTransformation1
    // purpose: transforms the array to reverse the columns
    public static void PrintTransformation1(char[][] lmao){
        for (int i = 0; i < lmao.length; i++){
            System.out.println();
            for (int j = lmao[i].length-1; j > -1; j--){
                System.out.print(lmao[i][j]);
            }
        }

        System.out.println();
        System.out.println();
    }

    // method: PrintTransformation2
    // purpose: reverses the rows and columns of the array into reverse columns and reverse rows, respectively.
    public static void PrintTransformation2(char[][] lmao){

        int k = 0;

        for (int i = lmao[k].length-1; i > -1; i--){
            System.out.println();
            for (int j = lmao.length-1; j > -1; j--){
                System.out.print(lmao[j][i]);
                k++;
            }
        }

        System.out.println();
    }
}

