package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entities.*;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer add(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Customer findById(long id) {
		Customer customer = em.find(Customer.class, id);
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		return null;
	}

}