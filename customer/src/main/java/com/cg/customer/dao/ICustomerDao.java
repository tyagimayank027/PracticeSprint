package com.cg.dao;

import com.cg.entities.*;

public interface ICustomerDao {
	Customer add(Customer customer);

    Customer findById(long id);

    Customer update(Customer customer);

}
