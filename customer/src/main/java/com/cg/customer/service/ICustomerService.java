package com.cg.service;
import com.cg.entities.*;

public interface ICustomerService {
	
	public Customer findById(long Id);
    public Customer createCustomer(String name);
    public Customer update(Long id,String name);

}
