/***************************************************************
 * file: Liu_BankAccount.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 5
 * date last modified: 28 Feb 2017
 *
 * purpose: This program sets the basis of the program by providing an abstract backbone
 * takes balance and sets the deposit amount and withdraw amount and account monthly processing
 *
 ****************************************************************/
public abstract class Liu_BankAccount{

    private double balance;
	private double serviceFee;
	private double apr;
	
	private int deposits = 0;
	private int withdrawals = 0;

    // SET: accept arguments for balance and apr
	// method: Liu_BankAccount
	// purpose: provides the constrictor
    public Liu_BankAccount(double balance, double apr){
		this.balance = balance;
		this.apr = apr;
	}

    // GET: balance
	// method: getBalance
	// purpose: returns balance
    public double getBalance(){
		return balance;	
	}

    // SET: Deposit
    // balance - amount
	// method: setDeposit
	// purpose: sets the balance amount
    public void setDeposit(double amount){
		balance += amount;
		deposits++;
	}


    // SET: withdrawals
    // balance - amount
	// method: setWithdrawal
	// purpose: withdraws money from account, if too much then not enough funds
    public void setWithdrawal(double amount){
		if (balance > amount) {
			balance -= amount;
			withdrawals++;
		}
		else
			System.out.println("Error - Not enough funds.");
	}
	
	// GET: withdrawals
	// return withdrawals
	// method: getWithdrawls
	// purpose: return how many withdrawals have been made
	public int getWithdrawals(){
		return withdrawals;
	}

    // SET: calcInterest
	// method: calcInterest
	// purpose: for account monthly process
    public void calcInterest(){
		balance = balance + (balance * (apr / 12));
	}

	// SET: setServiceFee
	// method: setServiceFee
	// purpose: sets the amount of fee charged for savings account
	public void setServiceFee(double amount){
		serviceFee += amount;
	}


    // SET: monthlyProcess
	// method: monthlyProcess
	// purpose: does the monthly process
    public void monthlyProcess(){
		balance -= serviceFee;
		calcInterest();
		withdrawals = 0;
		deposits = 0;
		serviceFee = 0.00;
	}

	// method: customerBalance
	// purpose: returns string of the customer's balance
	public void customersBalance(){
		System.out.printf("Account balance is: $%,.2f.%n", balance);
	}
}

