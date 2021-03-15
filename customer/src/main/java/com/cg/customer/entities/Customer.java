package com.cg.customer.entities;

import java.util.Set;

import javax.persistence.*;
import com.cg.items.entity.*;

@Entity
@Table(name = "custome_data")
public class Customer {
	@GeneratedValue
	@Id
	private Long Id;
	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Item> boughtItems;

	public Customer() {

	}

	public Customer(String name, Account account) {
		this.name = name;
		this.account = account;
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

}
