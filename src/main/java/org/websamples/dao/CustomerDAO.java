package org.websamples.dao;

import java.util.List;

import org.websamples.domain.Customer;

public interface CustomerDAO {
	
	
	List<Customer> getCustomers();
	
	Customer getCustomerById( int id );

	public void save( Customer customer );
	
	public void delete(int id);
	
}
