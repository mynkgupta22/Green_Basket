package com.masai.Services;


import java.util.List;

import com.masai.Exception.CustomerException;
import com.masai.Exception.UserException;
import com.masai.Model.Customer;



public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer viewCustomer(Integer customerId,String key)throws CustomerException,UserException;
	
	public List<Customer> viewCustomerList()throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException,UserException;
	
	public Customer removeCustomer(Integer customerId,String key) throws CustomerException,UserException;

}
