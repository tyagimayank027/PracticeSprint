package com.cg.entities;
import javax.persistence.*;

@Entity
@Table(name="custome_data")
public class Customer {
	@GeneratedValue
	@Id
	private long Id;
	private String name;
	
	
	
	public Customer() {
		
	}
	
	public Customer(String name,Account account) {
		this.name=name;
		this.account=account;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
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

	@Override
	public String toString() {
		return "Customer [id=" + Id + ", name=" + name + ", account=" + account + "]";
	}

}
