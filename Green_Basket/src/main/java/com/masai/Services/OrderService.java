package com.masai.Services;

import java.util.List;

import com.masai.Exception.OrderException;
import com.masai.Model.Cart;
import com.masai.Model.Order;

public interface OrderService {
	
	public Order addOrder(Order order,Integer cartId)throws OrderException;
	
	public Order viewOrder(Integer orderNo)throws OrderException;
	
	public Order updateOrderDetails(Order order)throws OrderException;
	
	public List<Order> viewAllOrders(Integer customerId)throws OrderException;
	
	public List<Order> viewCompleteOrdersList()throws OrderException;
	
	public Order deleteOrder(Integer orderNo)throws OrderException;
	

}
