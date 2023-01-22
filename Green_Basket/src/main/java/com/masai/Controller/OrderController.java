package com.masai.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Exception.OrderException;
import com.masai.Model.Cart;
import com.masai.Model.Order;
import com.masai.Model.VegetableDTO;
import com.masai.Services.OrderService;
@CrossOrigin
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/{cartId}")
	public ResponseEntity<Order> addOrder(@RequestBody Order order,@PathVariable Integer cartId) throws OrderException {
		
		Order saveOrder = orderService.addOrder(order,cartId);

		return new ResponseEntity<Order>(saveOrder,HttpStatus.CREATED);
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
