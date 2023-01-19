package com.masai.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.OrderException;
import com.masai.Model.Cart;
import com.masai.Model.Customer;
import com.masai.Model.Order;
import com.masai.Model.VegetableDTO;
import com.masai.Model.VegetableDto;
import com.masai.Repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	
	@Override
	public Order addOrder(Cart cart) throws OrderException {
		
		Double totalPrice=0.0;
		for(VegetableDTO  c : cart.getVegetable()) {
			totalPrice += c.getPrice();
		}
		Order order= new Order();
		order.setTotalAmount(totalPrice);
		order.setVegetableList(null);
		
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
