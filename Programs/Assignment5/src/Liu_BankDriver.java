/***************************************************************
 * file: Liu_BankDriver.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 5
 * date last modified: 28 Feb 2017
 *
 * purpose: This program drives the checkings account and savings account files
 * vand makes the accounts so the customer can deposit and withdraw money
 *
 ****************************************************************/
import java.util.Scanner;

public class Liu_BankDriver{
    // method: main
    // purpose: this method drives the two class files and allows the customer to deposit
    // withdraw, and maintain the account
    public static void main(String[] args) throws Exception{

        double balance = 0;
        double rate = 0;

        String choice;

        Liu_SavingsAccount savings = new Liu_SavingsAccount(15, rate);
        Liu_CheckingsAccount checkings = new Liu_CheckingsAccount(balance, rate);
        Scanner console = new Scanner(System.in);

        do{
            System.out.print("Which account would you like to access, regular or savings?: ");
            choice = console.nextLine();

            if (choice.equalsIgnoreCase("regular")){
                System.out.print("What action do you wish to perform \n(Withdraw, deposit, monthly processing)?: ");
                choice = console.nextLine();

                if (choice.equalsIgnoreCase("withdraw")){
                    System.out.print("Enter amount to withdraw: ");
                    balance = console.nextDouble();
                    if (checkings.getBalance() < balance ){
                        System.out.println("Error - Not enough funds.");
                        console.nextLine();
                    } else {
                        checkings.withdraw(balance);
                        checkings.customersBalance();
                        console.nextLine();
                    }
                    System.out.println();
                } else if (choice.equalsIgnoreCase("deposit")){
                    System.out.print("Enter amount to deposit: ");
                    checkings.deposit(console.nextDouble());
                    checkings.customersBalance();
                    console.nextLine();
                    System.out.println();

                } else if (choice.equalsIgnoreCase("monthly processing")){
                    checkings.accountMaintenance();
                    checkings.customersBalance();
                    System.out.println();

                } else if (choice.charAt(0) == 'q' || choice.charAt(0) == 'Q'){
                    System.exit(0);

                } else {
                    System.out.println("Please enter a valid choice.");
                    System.out.println();
                }

            } else if (choice.equalsIgnoreCase("savings")){
                System.out.print("What action do you wish to perform \n(Withdraw, deposit, monthly processing)?: ");
                choice = console.nextLine();

                if (choice.equalsIgnoreCase("withdraw")){
                    System.out.print("Enter amount to withdraw: ");
                    balance = console.nextDouble();

                    if (savings.getBalance() < balance){
                        System.out.println("Error - Not enough funds.");
                        console.nextLine();
                    } else {
                        savings.withdraw(balance);
                        console.nextLine();
                    }

                    System.out.println();
                    choice = "a";

                } else if (choice.equalsIgnoreCase("deposit")){
                    System.out.print("Enter amount to deposit: ");
                    savings.deposit(console.nextDouble());
                    console.nextLine();
                    System.out.println();

                } else if (choice.equalsIgnoreCase("monthly processing")){
                    savings.accountMaintenance();
                    System.out.println();

                } else if (choice.charAt(0) == 'q' || choice.charAt(0) == 'Q'){
                    System.exit(0);
                } else {
                    System.out.println("Please enter a valid choice..");
                    System.out.println();
                }
            } else if (choice.charAt(0) == 'q' || choice.charAt(0) == 'Q'){
                System.exit(0);
            } else {
                System.out.println("Please enter a valid choice.");
                System.out.println();
            }

        } while (choice.charAt(0) != 'q' || choice.charAt(0) != 'Q' );
    }
}
