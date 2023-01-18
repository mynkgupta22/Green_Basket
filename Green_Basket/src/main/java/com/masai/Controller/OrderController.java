package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Services.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

}
