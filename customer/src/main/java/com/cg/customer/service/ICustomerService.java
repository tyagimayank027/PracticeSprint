package com.cg.customer.service;

import java.util.Set;

import com.cg.customer.entities.*;
import com.cg.items.entity.*;

public interface ICustomerService {
	Customer findById(Long customerID);

	Customer createCustomer(String name);

	Customer addAmount(Long customerId, double amount);

	Set<Item> itemsBoughtByCustomer(Long customerId);
}
