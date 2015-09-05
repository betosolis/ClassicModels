package org.websamples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.websamples.dao.CustomerDAO;
import org.websamples.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getContacts() {
		return customerDAO.getCustomers();
	}

	@Override
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}
	

}
