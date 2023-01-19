package com.masai.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.OrderException;
import com.masai.Model.Cart;
import com.masai.Model.Order;
import com.masai.Model.VegetableDTO;
import com.masai.Services.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> addOrder(@RequestBody Cart cart) throws OrderException {
		
		Order order = orderService.addOrder(cart);
		
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}

	@GetMapping("/order/{orderNo}")
	public ResponseEntity<Order> viewOrder(@PathVariable("orderNo") Integer orderNo) throws OrderException {
            Order order = orderService.viewOrder(orderNo);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}


	@PutMapping("/order")
	public ResponseEntity<Order> updateOrderDetails(@RequestBody Order order) throws OrderException {
          Order updatedOrder = orderService.updateOrderDetails(order);
		
		return new ResponseEntity<>(updatedOrder,HttpStatus.ACCEPTED);
	}


	@GetMapping("/orders/{customerId}")
	public ResponseEntity<List<Order>> viewAllOrders(@PathVariable("customerId") Integer customerId) throws OrderException {
		List<Order> list=orderService.viewAllOrders(customerId);
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/order/{orderNo}")
	public ResponseEntity<Order> deleteOrder(@PathVariable("orderNo") Integer orderNo) throws OrderException {
         Order order = orderService.deleteOrder(orderNo);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/getOrders")
	public ResponseEntity<List<Order>> viewCompleteOrdersList() throws OrderException {
           List<Order> list=orderService.viewCompleteOrdersList();
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}


}
