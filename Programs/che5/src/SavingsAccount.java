public class SavingsAccount extends BankAccount {

    private boolean active;
    //method : SavingsAccount
    //purpose : act as constructor to class
    public SavingsAccount(double balance, double annualInterest) {

        super(balance, annualInterest);
        active = balance >= 25;
    }
    //method : savingsWithdraw
    //purpose : handles the withdrawal of savings account
    public void savingsWithdraw(double amount) {

        if(active)
            super.withdraw(amount);
        active = (getBalance() >= 25);

    }
    //method : savingsDeposit
    //purpose : handles the deposits of savings account
    public void savingsDeposit(double amount) {

        super.deposit(amount);
        active = (getBalance() >= 25);
    }
    //method : savingsMonthlyProcess
    //purpose : checks number of withdrawals and alters variables afterwards
    public void savingsMonthlyProcess() {

        if(getNumWithdrawals() > 4)
            addServiceCharge(getNumWithdrawals()-4);
        super.monthlyProcess();
        active = (getBalance() >= 25);
    }
    //method : status
    //purpose : prints out activity or inactivity of account based on its balance
    public void status() {

        if (super.getBalance() <= 25.0) {
            active = false;
            System.out.println ("Savings account is now inactive.");
        }
        else {
            active = true;
            System.out.println("Savings account is now active.");
        }
    }

}