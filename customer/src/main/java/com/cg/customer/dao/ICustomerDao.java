package com.cg.customer.dao;

import com.cg.customer.entities.*;

public interface ICustomerDao {
	Customer add(Customer customer);

	Customer findById(Long id);

	Customer update(Customer customer);

}
