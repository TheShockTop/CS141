abstract class BankAccount{

    protected double balance;
    private int numDeposits;
    private int numWithdrawals;
    private double annualInterest;
    private double serviceCharge;

    //method : BankAccount
//purpose : act as constructor to class
    public BankAccount(double balance, double annualInterest){

        this.balance = balance;
        this.annualInterest = annualInterest;

    }
    //method : deposit
//purpose : handles deposits
    public void deposit(double amount){

        balance += amount;
        numDeposits++;

    }
    //method : withdraw
//purpose : handles withdraws
    public void withdraw(double amount){

        if(balance>amount) {
            balance -= amount;
        }
        else
            System.out.println("Error: Cannot withdraw due to low balance");
        numWithdrawals++;
    }
    //method : calcInterest
//purpose : calculates interest
    public void calcInterest() {

        double monthlyInterest = annualInterest/12;
        balance += monthlyInterest*balance;
    }

    //method : monthlyProcess
//purpose : sets certain variables to 0
    public void monthlyProcess() {

        balance -= serviceCharge;
        calcInterest();
        numWithdrawals = 0;
        numDeposits = 0;
        serviceCharge = 0;
    }
    //method : getBalance
//purpose : returns balance
    public double getBalance() {

        return balance;

    }
    //method : getNumDeposits
//purpose : returns the numbered deposit
    public int getNumDeposits() {

        return numDeposits;

    }
    //method : getNumWithdrawals
//purpose : returns the numbered withdrawal
    public int getNumWithdrawals() {

        return numWithdrawals;

    }
    //method : addServiceCharge
//purpose : adds a service charge to the amount in bank
    protected void addServiceCharge(double amount) {

        serviceCharge += amount;

    }
    //method : show
//purpose : prints out balance of account
    public void show() {

        System.out.println("Account balance is: "+balance);

    }

}