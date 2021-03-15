package com.cg.items.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.items.entity.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private EntityManager em;

	public String generateString() {
		String s = "item";
		s = s + Math.random();
		return s;

	}

	@Override
	public Item add(Item item) {
		String id = generateString();
		item.setId(id);
		em.persist(item);
		return item;
	}

	@Transactional
	@Override
	public Item update(Item item) {
		item = em.merge(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = em.find(Item.class, itemId);
		return item;
	}
}