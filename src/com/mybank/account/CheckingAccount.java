package com.mybank.account;

public class CheckingAccount extends AbstractAccount {

	public CheckingAccount(String customer, String accountName, double balance, String accountNumber) {
		super(customer, accountName, balance, accountNumber);
	}

	@Override
	public Double deposit(double amount) throws IllegalArgumentException {
		// validate amount is good
		checkAmountIsPositiveElseThrow(amount);

		return super.deposit(amount);
	}

	@Override
	public Double withdraw(double amount) throws InsufficientFundsException {
		// validate amount is good
		checkAmountIsPositiveElseThrow(amount);
		// validate we have the funds
		checkForSufficientFundsElseThrow(amount);

		return super.withdraw(amount);
	}

	@Override
	public Double transfer(AbstractAccount toAccount, double amount) throws InsufficientFundsException {
		// validate amount is good
		checkAmountIsPositiveElseThrow(amount);
		// validate we have the funds
		checkForSufficientFundsElseThrow(amount);

		return super.transfer(toAccount, amount);
	}

}