package com.masai.Services;

import java.util.List;

import com.masai.Exception.CartException;
import com.masai.Exception.VegetableException;
import com.masai.Model.Cart;
import com.masai.Model.Vegetable;
import com.masai.Model.VegetableDTO;

public interface CartService {
	
	public Cart createCart(Cart cart)throws CartException;
	public Cart addToCart(List<VegetableDTO> veg, Integer cartId) throws VegetableException;	
	
	public VegetableDTO addVegToCart(VegetableDTO veg, Integer cartId)throws VegetableException;
	public Cart increaseVegQantity(Integer cartId, Integer quantity,Integer vegId) throws VegetableException;
	public Cart decreaseVegQantity(Integer cartId, Integer quantity,Integer vegId) throws VegetableException;
	public Cart removeVegetable(Integer cartId,Integer vegId) throws VegetableException;
	public Cart removeAllVegetable(Integer cartId) throws VegetableException;

	public List<VegetableDTO> viewAllItems(Integer cartId) throws VegetableException;
}
