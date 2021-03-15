package com.cg.customer.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.customer.dao.*;
import com.cg.customer.entities.*;
import com.cg.items.entity.Item;

@Service
public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao dao;

	@Autowired
	public void setDao(ICustomerDao dao) {
		this.dao = dao;
	}

	@Autowired
	private EntityManager em;

	@Override
	public Customer findById(Long Id) {
		Customer customer = dao.findById(Id);
		return customer;
	}

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		LocalDateTime currentTime = LocalDateTime.now();
		Account account = new Account(0, currentTime);
		em.persist(account);
		Customer customer = new Customer(name,account);
		return dao.add(customer);
	}
	

	@Override
	public Customer addAmount(Long customerId, double amount) {
		Customer c = findById(customerId);
		Account a=c.getAccount();
		a.setBalance(amount);
		em.persist(a);
		dao.update(c);
		return null;
	}

	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerId) {
		Customer customer= findById(customerId);
		Set<Item> item=customer.getBoughtItems();
		
		return item;
	}


}
