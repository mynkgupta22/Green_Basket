package com.masai.Services;

import java.util.List;

import com.masai.Exception.CartException;
import com.masai.Exception.VegetableException;
import com.masai.Model.Cart;
import com.masai.Model.Vegetable;
import com.masai.Model.VegetableDto;

public interface CartService {

	
	public Cart addCart(Cart cart)throws CartException;
	public Cart addToCart(List<VegetableDto> veg, Integer cartId) throws VegetableException;	
	
	public VegetableDto addVegToCart(VegetableDto veg, Integer cartId)throws VegetableException;
	
}
