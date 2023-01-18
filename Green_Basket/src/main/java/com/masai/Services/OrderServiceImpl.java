package com.masai.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.OrderException;
import com.masai.Model.Order;
import com.masai.Repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order addOrder(Order order) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order viewOrder(Integer orderNo) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrderDetails(Order order) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewAllOrders(Integer customerId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deleteOrder(Integer orderNo) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
