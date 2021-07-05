package com.mybank.account;

public class InsufficientFundsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 381837313842247447L;

	public InsufficientFundsException(String message) {
		super(message);
	}

}
