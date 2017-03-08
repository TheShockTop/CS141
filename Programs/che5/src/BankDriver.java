import java.io.*;
import java.util.Scanner;

public class BankDriver {
    //method : main
    //purpose : runs the previous classes using their methods through a looping selection for the user.
    public static void main(String args[])throws Exception {

        double balance = 0.0;
        double interestRate = 0.0;

        SavingsAccount sb1=new SavingsAccount(balance, interestRate);
        SavingsAccount sb2=new SavingsAccount(balance, interestRate);

        Scanner in = new Scanner (System.in);
        String choice;
        int num = 0;

        do {

            System.out.println("Which account would you like to access, regular or savings? :");


            choice=in.nextLine();

            if (choice.equalsIgnoreCase("regular")) {
                num = 0;
            }

            else if (choice.equalsIgnoreCase("savings")) {
                num = 1;
            }
            else if (choice.charAt(0) == 'q' || choice.charAt(0) == 'Q') {
                num = 5;
                System.exit(0);
            }
            switch(num) {
                case 0:System.out.println("What action do you wish to perform \n(Withdraw, deposit, monthly processing)?:");
                    choice = in.nextLine();
                    if (choice.equalsIgnoreCase("withdraw")) {
                        num = 0;
                    }
                    else if (choice.equalsIgnoreCase("deposit")) {
                        num = 1;
                    }
                    else if (choice.equalsIgnoreCase("monthly processing")) {
                        num = 2;
                    }
                    else {
                        System.out.println ("Error: incorrect action");

                    }
                    switch (num) {
                        case 0:
                            System.out.println("Enter amount to withdraw:");
                            sb1.withdraw(in.nextInt());
                            sb1.show();break;
                        case 1:
                            System.out.println("Enter amount to deposit:");
                            sb1.deposit(in.nextInt());
                            sb1.show();break;
                        case 2:
                            sb1.monthlyProcess(); break;
                    }
                    break;

                case 1:System.out.println("What action do you wish to perform \n(Withdraw, deposit, monthly processing)?:");
                    choice = in.nextLine();
                    if (choice.equalsIgnoreCase("withdraw")) {
                        num = 0;
                    }
                    else if (choice.equalsIgnoreCase("deposit")) {
                        num = 1;
                    }
                    else if (choice.equalsIgnoreCase("monthly processing")) {
                        num = 2;

                    }
                    else {
                        System.out.println ("Error: incorrect action");

                    }

                    switch (num) {
                        case 0:
                            System.out.println("Enter amount to withdraw:");
                            sb2.savingsWithdraw(in.nextInt());
                            sb2.show();break;
                        case 1:
                            System.out.println("Enter amount to deposit:");
                            sb2.savingsDeposit(in.nextInt());
                            sb2.show();break;
                        case 2:
                            sb2.savingsMonthlyProcess();
                            sb2.show(); break;
                    }
                    sb2.status();
                    break;
            }

            in.nextLine();

        } while(choice.charAt(0) != 'q' || choice.charAt(0) != 'Q');
    }
}