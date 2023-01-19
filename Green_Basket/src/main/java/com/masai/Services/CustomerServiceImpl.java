package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomerException;
import com.masai.Exception.UserException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Customer;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.UserSessionDao;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserSessionDao userSessionDao;

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerDao.save(customer);
	}

	@Override
	public Customer viewCustomer(Integer customerId, String key) throws CustomerException ,UserException{
		
		CurrentUserSession currentUserSession = userSessionDao.findByUuid(key);
		
		if(currentUserSession.equals(null)) {
			throw new UserException("Invalid session Id or Admin not Logged In");
		}
		
		Customer customer = customerDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer not exists with Id"+customerId));
	
		
		return customer;
	}

	@Override
	public List<Customer> viewCustomerList() throws CustomerException {
		List<Customer> customers = customerDao.findAll();
		
		if(customers.isEmpty()) {
			throw new CustomerException("No Customers Available");
		}
		
		return customers;
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException, UserException {
		CurrentUserSession currentUserSession = userSessionDao.findByUuid(key);
		
		if(currentUserSession.equals(null)) {
			throw new UserException("Invalid session Id or Admin not Logged In");
		}
		
		Customer updatedCustomer = customerDao.findById(customer.getCustomerId()).get();
		
		
		if(updatedCustomer.equals(null)) {
			throw new CustomerException("No Customer available with "+customer.getEmailId());
		}
		
//		updatedCustomer.setCustomerId(customer.getCustomerId());
//		updatedCustomer.setCustomerName(customer.getCustomerName());
//		updatedCustomer.setAddress(customer.getAddress());
//		updatedCustomer.setEmailId(customer.getEmailId());
//		updatedCustomer.setMobileNumber(customer.getMobileNumber());
//		updatedCustomer.setPassword(customer.getPassword());
		
		customerDao.save(customer);
		
		return customer;
	}

	@Override
	public Customer removeCustomer(Integer customerId, String key) throws CustomerException, UserException {
		CurrentUserSession currentUserSession = userSessionDao.findByUuid(key);
		
		if(currentUserSession.equals(null)) {
			throw new UserException("Invalid session Id or Admin not Logged In");
		}
		
		Customer customer = customerDao.findById(customerId)
								.orElseThrow(()->  new CustomerException("Customer not exists with Id"+customerId));
		
		customerDao.delete(customer);
		
		return customer;
	}

}
