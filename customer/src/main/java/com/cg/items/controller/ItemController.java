package com.cg.items.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.items.dto.BuyItemRequest;
import com.cg.items.dto.CreateItemRequest;
import com.cg.items.dto.ItemDetails;
import com.cg.items.entity.Item;
import com.cg.items.service.IItemService;
import com.cg.items.util.ItemUtil;

@RequestMapping("/items")
@RestController
public class ItemController {
	
	@Autowired
	private IItemService iService;
	
	@Autowired
	private ItemUtil util;
	
	@PostMapping("/add")
	public ItemDetails addItem(@RequestBody CreateItemRequest request )
	{
		Item item = iService.create(request.getPrice(),request.getDescription());
		ItemDetails I_D = util.toDetail(item);
		return I_D;
	}
	
	@GetMapping("/findbyid/{id}")
	public ItemDetails findById(@PathVariable String id)
	{
		Item item = iService.findById(id);
		ItemDetails I_D =util.toDetail(item);
		return I_D;
	}
	
	@PutMapping("/customer/add")
	public ItemDetails buyItem(@RequestBody BuyItemRequest request)
	{
		Item item = iService.buyItem(request.getI_id(),request.getC_id());
		ItemDetails I_D =util.toDetail(item);
		return I_D;
	}

}
