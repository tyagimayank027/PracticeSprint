package com.cg.customer.dto;

public class AddAmountRequest {

	private Long id;
	private double balance;

	public AddAmountRequest() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return balance;
	}

	public void setAmount(double balance) {
		this.balance = balance;
	}

}