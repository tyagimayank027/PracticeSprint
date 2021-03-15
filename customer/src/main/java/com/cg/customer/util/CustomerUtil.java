package com.cg.customer.util;

import org.springframework.stereotype.Component;

import com.cg.customer.dto.CustomerDetails;
import com.cg.customer.entities.Customer;
@Component
public class CustomerUtil {
	public CustomerDetails toDetail(Customer customer) {
		CustomerDetails cd = new CustomerDetails();
		cd.setId(customer.getId());
		cd.setBalance(customer.getAccount().getBalance());
		cd.setAccountId(customer.getAccount().getAccountId());
		cd.setName(customer.getName());
		return cd;
	}
 
}
