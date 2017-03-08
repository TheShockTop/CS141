/***************************************************************
 * file: Liu_LifeDriver.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 6
 * date last modified: 08 March 2017
 *
 * purpose: This program is the Driver for the class Liu_Life for Conway's Game of Life. This program asks the user for
 * the file and the amount of generations to calculate to the user's liking. It then passes on the arguments to the
 * constructor in Liu_Life.java
 *
 ****************************************************************/
import java.util.*;
import java.io.*;

public class Liu_LifeDriver{

    // method: main
    // purpose: this method calls Liu_Life constructor and inserts File to be read and number of iterations or
    // generations to be done
    // @param  String[] args  arguments from console
    public static void main(String[] args){
        new Liu_Life(getFile(), getInt());
        System.out.println();
    }

    // method: getFile
    // purpose: this method asks user for the file to be read for the scanner object to read in Liu_Life
    // if entered is not a file or does not exist, then recursive function is called and asks user for
    // an file again until an existing on is inputted
    private static File getFile(){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter file name: ");

        File varTmpDir = new File(console.nextLine());

        if(!varTmpDir.exists()){
            System.out.println("File was not found, please try again.");
        } else {
            return varTmpDir;
        }

        return getFile();
    }

    // method: getInt
    // purpose: this method asks user for the number of generations for the simulation to be ran
    // if invalid, then recursively called until a valid integer is inputted
    private static int getInt(){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter how many generations to compute: ");
        String holder = console.nextLine();

        if (isInteger(holder) && holder != null)
            return Integer.parseInt(holder);
        else
            System.out.println("Not a valid integer, please try again.");

        return getInt();
    }

    // :)
    // method: isInteger
    // purpose: this method checks if the string entered in getInt() is a integer this should never be implemented
    // because this is horrible and I am just messing around. Under no circumstances should this ever be implemented
    // in a production environment because this can go so badly in many ways
    // @param  s  String from getInt() to check if it is integer
    // @return      boolean if s is an integer or not
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
        // :)
    }
}
