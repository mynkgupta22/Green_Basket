package com.masai.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Model.Vegetable;
import com.masai.Repository.CartDao;
import com.masai.Repository.VegetableDao;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private VegetableDao vegetable;
	
	@Override
	public Vegetable addToCart(Vegetable veg) {
		// TODO Auto-generated method stub
		Vegetable veg1 = vegetable.save(veg);
		return veg1;
	}

}
