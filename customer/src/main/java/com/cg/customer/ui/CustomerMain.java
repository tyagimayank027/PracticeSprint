package com.cg.ui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.entities.*;
import com.cg.service.*;

@Component
public class CustomerMain {
	
	@Autowired
	private ICustomerService service;

	public static void main(String[] args) {
		CustomerMain app=new CustomerMain();
		app.start();

	}
	
	public void start() {
		
		Customer c1=service.createCustomer("Mayank Tyagi");
		System.out.println(c1);
		Customer c2=service.createCustomer("Naman");
		System.out.println(c2);
		
		Customer findC1=service.findById(2);
		System.out.println("Customer found with id "+ findC1.getId()+ "And name= "+findC1.getName());
		Customer findC2=service.findById(4);
		System.out.println("Customer found with id "+ findC2.getId()+ "And name= "+findC2.getName());
		
		
		
	}

}
