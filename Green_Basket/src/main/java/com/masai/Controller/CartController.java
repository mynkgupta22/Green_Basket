package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Cart;
import com.masai.Model.VegetableDTO;
import com.masai.Services.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartservice;
	
	@PostMapping("/cart")
	public ResponseEntity<Cart> createCartHandller(@RequestBody Cart cart){
		return new ResponseEntity<>(cartservice.createCart(cart),HttpStatus.CREATED);
	}
	
	@PostMapping("/add/{id}")
	public ResponseEntity<VegetableDTO> addToCartHandller(@RequestBody VegetableDTO veg,@PathVariable Integer id){
		VegetableDTO vegs = cartservice.addVegToCart(veg, id);
		return new ResponseEntity<VegetableDTO>(vegs, HttpStatus.CREATED);
	}
	
	@PutMapping("/ince/{cartid}/{vegid}/{quantity}")
	public ResponseEntity<Cart> increaseVegQuantityHandller(@PathVariable("cartid")Integer cartid,@PathVariable("vegid")Integer vegid,@PathVariable("quantity")Integer quantity){
		Cart cart = cartservice.increaseVegQantity(cartid, quantity, vegid);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	@PutMapping("/decr/{cartid}/{vegid}/{quantity}")
	public ResponseEntity<Cart> decreaseVegQuantityHandller(@PathVariable("cartid")Integer cartid,@PathVariable("vegid")Integer vegid,@PathVariable("quantity")Integer quantity){
		Cart cart = cartservice.decreaseVegQantity(cartid, quantity, vegid);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	@PutMapping("/remove/{cartid}/{vegid}/{quantity}")
	public ResponseEntity<Cart> removeVegetableHandller(@PathVariable("cartid")Integer cartid,@PathVariable("vegid")Integer vegid,@PathVariable("quantity")Integer quantity){
		Cart cart = cartservice.increaseVegQantity(cartid, quantity, vegid);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	@GetMapping("removeAll/{id}")
	public ResponseEntity<Cart> removeAllVegetableHandller(@PathVariable("id")Integer cartid){
		Cart cart = cartservice.removeAllVegetable(cartid);
		return new ResponseEntity<>(cart,HttpStatus.FOUND);
	}
	@GetMapping("view/{id}")
	public ResponseEntity<List<VegetableDTO>> listOfAllVegetableHandller(@PathVariable("id")Integer cartid){

		List<VegetableDTO> lists = cartservice.viewAllItems(cartid);
		return new ResponseEntity<>(lists,HttpStatus.ACCEPTED);
	}
	
}
