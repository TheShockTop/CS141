/***************************************************************
 * file: Liu_Decoder.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 1
 * date last modified: 12 - January - 2017
 *
 * purpose: This program accepts argument input from the describing the file to be
 * deciphered. The program will take the first line string and the second line
 * using the second line to get the characters, ultimately creating a 'secret' message.
 *
 ****************************************************************/
import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Liu_Decoder {
    static boolean DEBUG = false;

    // method: main
    // purpose: this method takes argument input from the describing the file to be
    // deciphered. The program will take the first line string and the second line
    // using the second line to get the characters, ultimately creating a 'secret' message.
    public static void main(String[] args){

        String cipher, message, deciphered = "";

        if (DEBUG){
            System.out.printf("DEBUG: ARGS[0] PRINT: %s.%n", args[0]);
        }

        Scanner arg = new Scanner(System.in);

        message = arg.nextLine();
        cipher = arg.nextLine();

        if (DEBUG){
            System.out.printf("DEBUG: MESSAGE STRING: %s.%n", message);
            System.out.printf("DEBUG: CIPHER STRING: %s.%n", cipher);
        }

        String[] cipherholder = cipher.split(" "); // if trailing, then ,-1

        int[] cipherconverted = new int[cipherholder.length];

        for (int i = 0; i < cipherholder.length; i++) {
            try {
                cipherconverted[i] = Integer.parseInt(cipherholder[i]);
            } catch (NumberFormatException e) {
                System.out.print("Printing array: ");
                for (int k = 0; k < cipherholder.length; k++){
                    System.out.println(cipherholder[k]);
                }
                System.out.println("\n" + Arrays.toString(args));
                System.err.println("Error located in cipherholder to ciphercoverted: " + e);
            }
        }
        for (int j = 0; j < cipherconverted.length; j++ ){
            int value = cipherconverted[j];
            char character = message.charAt(value);

            deciphered += character;
        }

        arg.close();

        System.out.println("Your secret message is: " + deciphered);
    }
}
