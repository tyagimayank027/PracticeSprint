package com.cg.customer.ui;

import java.util.Set;

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
		System.out.println("Customer id " + findC1.getId() +" "+ "And name= " + findC1.getName());
		Customer findC2 = service.findById((long) 4);
		System.out.println("Customer id " + findC2.getId() +"  "+"And name= " + findC2.getName());

		Item i1 = itemService.create(50.0, "Milk");
		System.out.println(
				"Item " + i1.getId() + " " + i1.getDescription() + " " + i1.getPrice() + " " + i1.getAddedDate());

		Item i2 = itemService.create(350.0, "Toy");
		System.out.println(
				"Item " + i2.getId() + " " + i2.getDescription() + " " + i2.getPrice() + " " + i2.getAddedDate());

		Item item1bought = itemService.buyItem(i1.getId(), c1.getId());
		System.out.println("Item bought is = " + item1bought.getDescription());

		Item item2bought = itemService.buyItem(i2.getId(), c1.getId());
		System.out.println("Item bought is = " + item2bought.getDescription());

		Set<Item> item1 = service.itemsBoughtByCustomer(c1.getId());
		for (Item item : item1) {
			System.out.println(item.getDescription());

			Customer customer1 = service.addAmount(c1.getId(), 3000.0);
			System.out.println(customer1);
		}

	}

}
