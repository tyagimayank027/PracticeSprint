package com.cg.service;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dao.*;
import com.cg.entities.*;


@Service
public class CustomerServiceImpl implements ICustomerService {
	
	
	private ICustomerDao dao;
	@Autowired
	public void setDao(ICustomerDao dao){
        this.dao = dao;
    }
	
	@Autowired
	private EntityManager em;

	@Override
	public Customer findById(long Id) {
		Customer customer=dao.findById(Id);
		return customer;
	}

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		LocalDateTime currentTime=LocalDateTime.now();
		Account account=new Account(0,currentTime);
		em.persist(account);
		Customer customer=new Customer(name,account);
		return dao.add(customer);
	}

	@Override
	public Customer update(Long id, String name) {
		
		return null;
	}
	
	
}
