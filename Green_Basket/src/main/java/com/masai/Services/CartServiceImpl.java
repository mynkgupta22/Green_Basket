package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CartException;
import com.masai.Exception.VegetableException;
import com.masai.Model.Cart;
import com.masai.Model.Vegetable;
import com.masai.Model.VegetableDTO;
import com.masai.Repository.CartDao;
import com.masai.Repository.OrderDao;
import com.masai.Repository.VegetableDao;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private VegetableDao vegetable;
	

	
	@Override
	public Cart createCart(Cart cart) throws CartException {
		Cart createcart = cartDao.save(cart);
		if(createcart == null) {
			throw new CartException("Not created");
		}else {
			return createcart;
		}
		
	}


	@Override
	public Cart addToCart(List<VegetableDTO> veg, Integer cartId) throws VegetableException {
		Optional<Cart> cart = cartDao.findById(cartId);
		if(cart.isPresent()) {
			Cart carts = cart.get();
			for(VegetableDTO dto : veg) {
				//if name and quantity 
				
			}
			carts.setVegetable(veg);
			return carts;
		}else throw new VegetableException("Cart Not found");
		
	}


	@Override
	public VegetableDTO addVegToCart(VegetableDTO veg, Integer cartId) throws VegetableException {
		Optional<Cart> cartopt = cartDao.findById(cartId);
		if(cartopt.isPresent()) {
			Cart myCart = cartopt.get();
			Optional<Vegetable> stock = vegetable.findById(veg.getVegId());
			if(!stock.isPresent()) {
				throw new VegetableException("Not found vegetable");
			}
			Vegetable vegsto = stock.get();
			if(vegsto.getQuantity() > veg.getQuantity()) {
				vegsto.setQuantity(vegsto.getQuantity()-veg.getQuantity());
				vegetable.save(vegsto);
			}else {
				throw new VegetableException("Stock is "+vegsto.getQuantity()+" less than given"+veg.getQuantity());
			}			
			
			veg.setPrice(vegsto.getPrice());
			myCart.getVegetable().add(veg);
			Cart addcart = cartDao.save(myCart);
			
		}
		return veg;
	}


	@Override
	public Cart increaseVegQantity(Integer cartId, Integer quantity, Integer vegId) throws VegetableException {
		Optional<Cart> cart = cartDao.findById(cartId);
		if(cart.isPresent()) {
			Optional<Vegetable> veg = vegetable.findById(vegId);
			if(veg.get().getQuantity() > quantity) {
				veg.get().setQuantity(veg.get().getQuantity()-quantity);
				vegetable.save(veg.get());
			}else {
				throw new VegetableException("quantity not available");
			}
//			cart.get().getVegetable().forEach(VegetableDTO list: );
			for (VegetableDTO list : cart.get().getVegetable()) {
				if(list.getVegId() == vegId) {
					list.setQuantity(list.getQuantity()+quantity);
				}
			}
			Cart newcart = cartDao.save(cart.get());
			return newcart;
		}else {
			throw new VegetableException("cartId not found go to addtocart");
		}
		
	}


	@Override
	public Cart decreaseVegQantity(Integer cartId, Integer quantity, Integer vegId) throws VegetableException {
		Optional<Cart> cart = cartDao.findById(cartId);
		if(cart.isPresent()) {
//			cart.get().getVegetable().forEach(VegetableDTO list: );
			for (VegetableDTO list : cart.get().getVegetable()) {
				if(list.getVegId() == vegId) {
					list.setQuantity(list.getQuantity()-quantity);
				}
			}
			Cart newcart = cartDao.save(cart.get());
			return newcart;
		}else {
			throw new VegetableException("cartId not found go to addtocart");
		}
	}


	@Override
	public Cart removeVegetable(Integer cartId, Integer vegId) throws VegetableException {
		Optional<Cart> opt = cartDao.findById(cartId);
		if(opt.isPresent()) {
			Cart cart=opt.get();
			List<VegetableDTO> lists = cart.getVegetable();
			VegetableDTO dto = null;
			for (VegetableDTO list : lists) {
				if(list.getVegId() == vegId) {
					 dto = list;
					 lists.remove(dto);
					break;
				}
				
			}

			cart.setVegetable(lists);
			Cart newcart = cartDao.save(cart);
			return newcart;
		}else {
			throw new VegetableException("cartId not found to remove");
		}
	}


	@Override
	public Cart removeAllVegetable(Integer cartId) throws VegetableException {
		Optional<Cart> cart = cartDao.findById(cartId);
		if(cart.isPresent()) {
			
			cart.get().setVegetable(null);
			Cart newcart = cartDao.save(cart.get());
			return newcart;
		}else {
			throw new VegetableException("cartId not found to remove all");
		}
	}


	@Override
	public List<VegetableDTO> viewAllItems(Integer cartId) throws VegetableException {
		Optional<Cart> cart = cartDao.findById(cartId);
		if(cart.isPresent()) {
			List<VegetableDTO> dto =  cart.get().getVegetable();
			return dto;
		}else {
			throw new VegetableException("cartId not found ");
		}
	}

}
