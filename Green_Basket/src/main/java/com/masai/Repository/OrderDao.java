package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Exception.OrderException;
import com.masai.Model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

	
	public List<Order> findByCustomerId(Integer customerid);
}
