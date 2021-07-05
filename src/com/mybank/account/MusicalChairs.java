package com.mybank.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MusicalChairs {

	public static class AccountBalanceComparator implements Comparator<AbstractAccount> {

		@Override
		public int compare(AbstractAccount account1, AbstractAccount account2) {
			// Compare returns a negative number if account 1, should be listed bfore
			// account 2
			// A positive number, if account 2 should be listed before account 1
			// Returns 0, if they are considered the same
			if (account1.getBalance() > account2.getBalance()) {
				return -1;
			} else if (account1.getBalance() < account2.getBalance()) {
				return 1;
			} else {
				return 0;
			}
		}

	}

	public static void play() throws InsufficientFundsException {

		CheckingAccount one = new CheckingAccount("customer one", "customer ones account", 100.0, "c1");
		SavingsAccount two = new SavingsAccount("Saver two", "Savers saving account", 100.0, "s2");
		CheckingAccount three = new CheckingAccount("customer three", "cutomer threes account", 100.0, "c3");
		SavingsAccount four = new SavingsAccount("Saver four", "Savers fours saving account", 100.0, "s4");
		CheckingAccount five = new CheckingAccount("customer five", "cutomer fives account", 100.0, "c5");

		List<AbstractAccount> allAccounts = Arrays.asList(one, two, three, four, five);

		for (int amount = 1; amount < 1000; amount++) {
			int i = amount % 5; // modulo (%) nifty little trick to keep a number between 0 & 4 in this case
			int j = (i + 1) % 5;
			AbstractAccount fromAccount = allAccounts.get(i);
			AbstractAccount toAccount = allAccounts.get(j);

			// transfer money!!!

			Double ammountTransferred = fromAccount.transfer(toAccount, amount);

			// check if transfer worked, if not, break out of loop

			if (ammountTransferred == null) {
				break;
			}

		}

		System.out.println("Account one balance: $" + one.getBalance());
		System.out.println("Account two balance: $" + two.getBalance());
		System.out.println("Account three balance: $" + three.getBalance());
		System.out.println("Account four balance: $" + four.getBalance());
		System.out.println("Account five balance: $" + five.getBalance());

	}

	public static void playWithCollections() {
		System.out.println("New play method");
		// Generate 5 bank accounts, mix of checking & saving accounts
		// Different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// create new account with balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// saving
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add account to a collection (list)
			accountsList.add(thisAccount);
		}
		System.out.println(accountsList);

		// keep transferring money, until a transfer fails (because of too little money
		// left)
		for (int amount = 1; amount < 2000; amount++) {
			int i = amount % 5; // modulo (%) nifty little trick to keep a number between 0 & 4 in this case
			int j = (i + 1) % 5;
			AbstractAccount fromAccount = accountsList.get(i);
			AbstractAccount toAccount = accountsList.get(j);

			// transfer money!!!
			try {
				fromAccount.transfer(toAccount, amount);
			} catch (InsufficientFundsException e) {
				break;
			}

		}

		// Print winners / losers. Just print all accounts
		for (AbstractAccount account : accountsList) {
			System.out.println(account.getAccountName() + " - balance : " + account.getBalance());
		}

	} // end of playWithCollections()

	public static void playWithSet() {
		System.out.println("Inside play with set");
		// Generate 5 bank accounts, mix of checking & saving accounts
		// Different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// create new account with balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// saving
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add account to a collection (list)
			accountsList.add(thisAccount);
			// add again so we have duplicates
			accountsList.add(thisAccount);
		}
		System.out.println(accountsList);

		// find the unique set inside accounts list
		Set<AbstractAccount> uniqueAccounts = new HashSet<>(accountsList);

		System.out.println("Unique accounts: " + uniqueAccounts);
	}

	public static void playWithMap() {
		System.out.println("Inside playWithMap");
		// Generate 5 bank accounts, mix of checking & saving accounts
		// Different balances to start with
		// This time chuck em into a map, with their account number as key
		Map<String, AbstractAccount> accountsMap = new HashMap<>();

		for (int i = 0; i < 5; i++) {
			// create new account with balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = "#" + i;
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// saving
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add account to a collection (map)
			accountsMap.put(accountNumber, thisAccount);
		}
		System.out.println(accountsMap);

		// we can fetch just the keys
		accountsMap.keySet();

		// or get a list of all the values
		accountsMap.values();
	}

	public static void playWithSorting() {
		System.out.println("Inside play with sorting");
		// Generate 5 bank accounts, mix of checking & saving accounts
		// Different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// create new account with balance
			String customer = "Customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// saving
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add account to a collection (list)
			accountsList.add(thisAccount);
		}
		System.out.println(accountsList);

		// sort the list by balance
		accountsList.sort(new AccountBalanceComparator());
		System.out.println("Sorted by highest balance first: " + accountsList);
		
		// do the same thing with tree set
		// beware: will remove duplicates!!!
		Set<AbstractAccount> sortedSet = new TreeSet<>(new AccountBalanceComparator());
		sortedSet.addAll(accountsList);
		System.out.println("Sorted with a Tree Set: " + sortedSet);

	}

}
