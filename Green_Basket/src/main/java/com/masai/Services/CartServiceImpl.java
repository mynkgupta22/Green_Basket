package com.masai.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CartException;
import com.masai.Exception.VegetableException;
import com.masai.Model.Cart;
import com.masai.Model.Vegetable;
import com.masai.Model.VegetableDto;
import com.masai.Repository.CartDao;
import com.masai.Repository.OrderDao;
import com.masai.Repository.VegetableDao;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private VegetableDao vegetable;
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Cart addCart(Cart cart) throws CartException {
		// TODO Auto-generated method stub
		return cartDao.save(cart);
		
	}


	@Override
	public Cart addToCart(List<VegetableDto> veg, Integer cartId) throws VegetableException {
		// TODO Auto-generated method stub
		Optional<Cart> cart = cartDao.findById(cartId);
		if(cart.isPresent()) {
			Cart carts = cart.get();
			for(VegetableDto dto : veg) {
				//if name and quantity 
				
			}
			carts.setVegetable(veg);
			return carts;
		}else throw new VegetableException("Cart Not found");
		
	}


	@Override
	public VegetableDto addVegToCart(VegetableDto veg, Integer cartId) throws VegetableException {
		// TODO Auto-generated method stub
		Optional<Cart> cartopt = cartDao.findById(cartId);
		if(cartopt.isPresent()) {
			Cart myCart = cartopt.get();
//			Vegetable stock = 
			
			
			
			
			
			
			myCart.getVegetable().add(veg);
			Cart addcart = cartDao.save(myCart);
			System.out.println(addcart.getCustomer().getCustomerName());
			
		}
		orderDao.findById(cartId);
		return ;
	}

}
