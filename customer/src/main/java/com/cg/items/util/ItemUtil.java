package com.cg.items.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.items.dto.ItemDetails;
import com.cg.items.entity.Item;

@Component
public class ItemUtil {
	
	public ItemDetails toDetail(Item item)
	{
		ItemDetails item_d=new ItemDetails();
		item_d.setId(item.getId());
		item_d.setPrice(item.getPrice());
		item_d.setDescription(item.getDescription());
		if(item.getBoughtBy() != null) {
			item_d.setC_id(item.getBoughtBy().getId());
			item_d.setC_name(item.getBoughtBy().getName());
		}
		return item_d;
	}
	public Set<ItemDetails> toDetailSet(Set<Item>set){
		Set<ItemDetails>s=new HashSet();
		for(Item item:set)
		{
			s.add(toDetail(item));
		}
		return s;
	}
}
