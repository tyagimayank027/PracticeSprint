package com.cg.customer.ui;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customer.entities.*;
import com.cg.customer.service.*;
import com.cg.items.service.*;
import com.cg.items.entity.*;

@Component
public class CustomerMain {

	@Autowired
	private ICustomerService service;
	@Autowired
	private IItemService itemService;


	public void start() {

		Customer c1 = service.createCustomer("Mayank Tyagi");
		System.out.println(c1);
		Customer c2 = service.createCustomer("Naman");
		System.out.println(c2);

		Customer findC1 = service.findById((long) 2);
		System.out.println("Customer id " + findC1.getId() + "And name= " + findC1.getName());
		Customer findC2 = service.findById((long) 4);
		System.out.println("Customer id " + findC2.getId() + "And name= " + findC2.getName());
		
		Item chocolate = itemService.create(150.0,"choco");
		System.out.println("Item "+chocolate.getItem()+" "+chocolate.getDescription()+" "+chocolate.getPrice()+" "
				+chocolate.getAddedDate());
		
		Item rice = itemService.create(350.0, "Rice");
		System.out.println("Item "+rice.getItem()+" "+rice.getDescription()+" "+rice.getPrice()+" "
				+rice.getAddedDate());
	}

}
