/***************************************************************
 * file: Liu_CheckingsAccount.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 5
 * date last modified: 28 Feb 2017
 *
 * purpose: This program extends the abstract class Liu_BankAccount
 * and makes a checkings account for the customer to use
 *
 ****************************************************************/
public class Liu_CheckingsAccount extends Liu_BankAccount {

	// method: Liu_CheckingsAccount
	// purpose: sets the constrictor up
	public Liu_CheckingsAccount(double balance, double interest){
		super(balance, interest);
	}

	// method: withdraw
	// purpose: this method withdraws money from the account calling the superclass
	public void withdraw(double amount){
		super.setWithdrawal(amount);
	}

	// method: deposit
	// purpose: this method deposits money calling the superclass
	public void deposit(double amount){
		super.setDeposit(amount);
	}

	// method: accountMaintenance
	// purpose: this method does the monthly process by calling the superclass
	public void accountMaintenance(){
		if (getWithdrawals() > 4)
			setServiceFee(getWithdrawals() - 4);
		super.monthlyProcess();
	}


}
