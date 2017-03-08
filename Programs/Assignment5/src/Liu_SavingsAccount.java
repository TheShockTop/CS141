/***************************************************************
 * file: Liu_SavingsAccount.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 5
 * date last modified: 28 Feb 2017
 *
 * purpose: This program extends the abstract class Liu_BankAccount and makes
 * a savings account for the customer to use
 *
 ****************************************************************/
public class Liu_SavingsAccount extends Liu_BankAccount {

    private boolean active;

    // method: Liu_SavingsAccount
    // purpose: provides the constructor to input commands
    public Liu_SavingsAccount(double balance, double interest){
        super(balance, interest);
        // account will be active if balance is greater than 25.
        active = balance >= 25;
    }

    // method: isActive
    // purpose: check whether savings account is active or not
    public void isActive(){
        if (getBalance() >= 25) {
            active = true;
            System.out.println("Savings account is now active.");
        } else {
            active = false;
            System.out.println("Savings account is now inactive.");
        }
    }

    // method: withdraw
    // purpose: withdraws money from the savings account
    public void withdraw(double amount){
        if (active)
            super.setWithdrawal(amount);
        super.customersBalance();
        isActive();
    }

    // method: deposit
    // purpose: deposits money to the savings account
    public void deposit(double amount){
        super.setDeposit(amount);
        super.customersBalance();
        isActive();
    }

    // method: accountMaintenance
    // purpose: performs the monthly process
    public void accountMaintenance(){
        if (getWithdrawals() > 4)
            setServiceFee(getWithdrawals() - 4);
        super.monthlyProcess();
        super.customersBalance();
        isActive();
    }
}
