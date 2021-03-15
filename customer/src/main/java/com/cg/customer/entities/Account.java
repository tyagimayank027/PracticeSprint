package com.cg.customer.entities;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class Account {
	@GeneratedValue
	@Id
	private Long accountId;
	private double balance;
	private LocalDateTime created;

	public Account() {
	}

	public Account(double balance, LocalDateTime created) {
		this.balance = balance;
		this.created = created;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}