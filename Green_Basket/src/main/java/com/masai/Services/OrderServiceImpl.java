package com.masai.Services;

import java.util.List;
import java.util.Optional;

import com.masai.Exception.CartException;
import com.masai.Repository.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.OrderException;
import com.masai.Model.Cart;
import com.masai.Model.Customer;
import com.masai.Model.Order;
import com.masai.Model.VegetableDTO;

import com.masai.Repository.OrderDao;



@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CartDao cartDao;
	
	@Override
	public Order addOrder(Order order,Integer cartId) throws OrderException {

		Optional<Cart> opt = cartDao.findById(cartId);

		if(opt.isEmpty()){
			throw new CartException("No Cart Available with Id");
		}

		Cart cart = opt.get();
         order.setCart(cart);
		Double totalPrice=0.0;
		for(VegetableDTO  c : cart.getVegetable()) {
			totalPrice += c.getPrice()*c.getQuantity();
		}
		//Order order= new Order();
		order.setTotalAmount(totalPrice);
		order.setVegetableList(cart.getVegetable());
		order.setStatus("Successful");
		order.setCustomerId(cart.getCustomerId());
		
		orderDao.save(order);
		
		return order;
	}

	@Override
	public Order viewOrder(Integer orderNo) throws OrderException {
		Optional<Order> opt=orderDao.findById(orderNo);
		if(opt.isPresent()) {
			Order order = opt.get();
			return order;
		}
		throw new OrderException("Order Id is wrong");
	}

	@Override
	public Order updateOrderDetails(Order order) throws OrderException {
		Optional<Order> existingOrder=orderDao.findById(order.getOrderNo());
		if(existingOrder.isPresent()) {
			Order updatedOrder=existingOrder.get();
			updatedOrder=orderDao.save(order);
			return updatedOrder;
		}
		throw new OrderException("Order not found");
	}

	@Override
	public List<Order> viewAllOrders(Integer customerId) throws OrderException {
		List<Order> list=orderDao.findByCustomerId(customerId);
		if(list.isEmpty()) {
			throw new OrderException("No order found");
		}
		return list;
	}

	@Override
	public Order deleteOrder(Integer orderNo) throws OrderException {
		Optional<Order> opt=orderDao.findById(orderNo);
		if(opt.isPresent()) {
			Order order = opt.get();
			orderDao.delete(order);
			return order;
		}
		throw new OrderException("Order Id is wrong");
	}

	@Override
	public List<Order> viewCompleteOrdersList() throws OrderException {
		List<Order> list=orderDao.findAll();
		if(list.isEmpty()) {
			throw new OrderException("No order found");
		}
		return list;
	}

}
