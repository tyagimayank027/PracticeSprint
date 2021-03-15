package com.cg.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customer.dto.AddAmountRequest;
import com.cg.customer.dto.CreateCustomerRequest;
import com.cg.customer.dto.CustomerDetails;
import com.cg.customer.entities.Customer;
import com.cg.customer.service.ICustomerService;
import com.cg.customer.util.CustomerUtil;

@RequestMapping("/customer")
@RestController
public class CustomerRestController {
  @Autowired
  private ICustomerService service;
  @Autowired
  private CustomerUtil util;
  
  @PostMapping("/add")
  public CustomerDetails add(@RequestBody CreateCustomerRequest request) {
	  Customer customer = service.createCustomer(request.getName());
	 CustomerDetails cd= util.toDetail(customer);
	  return cd;
  }
  @GetMapping("/findbyid/{id}")
	public CustomerDetails findById(@PathVariable Long id)
	{
	  Customer customer = service.findById(id);
		CustomerDetails cd= util.toDetail(customer);
		return cd;
	}
	
	@PutMapping("/account/amount")
	public CustomerDetails addAmount(@RequestBody AddAmountRequest request)
	{
		Customer customer = service.addAmount(request.getId(), request.getAmount());
		CustomerDetails cd=util.toDetail(customer);
		return cd;
	}
  
}
