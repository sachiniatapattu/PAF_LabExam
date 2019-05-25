package com.shoppingcart.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.model.ShoppingCart;

import com.shoppingcart.repository.ShoppingcartRepository;

public class ShoppingcartDAO {
	
ShoppingcartRepository shoppingcartRepository;

	public List<ShoppingCart> findAll() {
		return shoppingcartRepository.findAll();
	}


	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public ShoppingCart save(@Valid ShoppingCart itm) {
		return shoppingcartRepository.save(itm);
	}

	public ShoppingCart findOne(Long itmId) {
		Optional<ShoppingCart> op = shoppingcartRepository.findById(itmId);
		if(op.isPresent()) {
		return op.get();
		}
		else {
		return null;
		}
		
		
	}

	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public void delete(ShoppingCart itm) {
		shoppingcartRepository.delete(itm);
		
	}

}

